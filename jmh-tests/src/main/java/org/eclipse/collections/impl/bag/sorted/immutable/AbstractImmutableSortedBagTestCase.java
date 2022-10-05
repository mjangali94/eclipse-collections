/*
 * Copyright (c) 2022 Goldman Sachs and others.
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
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.ListIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.sortedbag.ImmutableSortedBagMultimap;
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
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.collection.immutable.AbstractImmutableCollectionTestCase;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.SortedBags;
import org.eclipse.collections.impl.factory.SortedSets;
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
import org.eclipse.collections.impl.multimap.bag.sorted.mutable.TreeBagMultimap;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractImmutableSortedBagTestCase extends AbstractImmutableCollectionTestCase {

    @Override
    protected abstract ImmutableSortedBag<Integer> classUnderTest();

    protected abstract ImmutableSortedBag<Integer> classUnderTest(Comparator<? super Integer> comparator);

    protected <T> ImmutableSortedBag<T> newWithOccurrences(ObjectIntPair<T>... elementsWithOccurrences) {
        TreeBag<T> bag = TreeBag.newBag();
        for (int i = 0; i < elementsWithOccurrences.length; i++) {
            ObjectIntPair<T> itemToAdd = elementsWithOccurrences[i];
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag.toImmutable();
    }

    protected abstract <T> ImmutableSortedBag<T> newWith(T... elements);

    protected abstract <T> ImmutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements);

    @Test(expected = NullPointerException.class)
    public void noSupportForNull() {
        this.classUnderTest().newWith(null);
    }

    @Test
    public void equalsAndHashCode() {
        ImmutableSortedBag<Integer> immutable = this.classUnderTest();
        MutableSortedBag<Integer> mutable = TreeBag.newBag(immutable);
        Verify.assertEqualsAndHashCode(mutable, immutable);
        Verify.assertPostSerializedEqualsAndHashCode(immutable);
        Assert.assertNotEquals(FastList.newList(mutable), immutable);
        ImmutableSortedBag<Integer> bag1 = SortedBags.immutable.of(1, 1, 1, 4);
        ImmutableSortedBag<Integer> bag2 = SortedBags.immutable.of(1, 1, 1, 3);
        Assert.assertNotEquals(bag1, bag2);
    }

    @Test
    public void anySatisfyWithOccurrences() {
        ImmutableSortedBag<Integer> bag = this.newWith(1, 2, 2);
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals(1)));
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals(2) && value == 2));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals(2) && value == 6));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals(20)));
    }

    @Test
    public void allSatisfyWithOccurrences() {
        ImmutableSortedBag<Integer> bag = this.newWith(1, 2, 2);
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> object > 0));
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals(1) && value == 1));
    }

    @Test
    public void noneSatisfyWithOccurrences() {
        ImmutableSortedBag<Integer> bag = this.newWith(1, 2, 2);
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> object > 100));
        Assert.assertFalse(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(1) && value == 1));
    }

    @Test
    public void detectWithOccurrences() {
        ImmutableSortedBag<Integer> bag = this.newWith(1, 2, 2);
        Assert.assertEquals((Integer) 1, bag.detectWithOccurrences((object, value) -> object.equals(1) && value == 1));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals(100)));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals(1) && value == 100));
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(-1, SortedBags.immutable.of(1, 1, 2, 2).compareTo(SortedBags.immutable.of(1, 1, 2, 2, 2)));
        Assert.assertEquals(0, SortedBags.immutable.of(1, 1, 2, 2).compareTo(SortedBags.immutable.of(1, 1, 2, 2)));
        Assert.assertEquals(1, SortedBags.immutable.of(1, 1, 2, 2, 2).compareTo(SortedBags.immutable.of(1, 1, 2, 2)));
        Assert.assertEquals(-1, SortedBags.immutable.of(1, 1, 2, 2).compareTo(SortedBags.immutable.of(1, 1, 3, 3)));
        Assert.assertEquals(1, SortedBags.immutable.of(1, 1, 3, 3).compareTo(SortedBags.immutable.of(1, 1, 2, 2)));
        Assert.assertEquals(1, SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 2, 2, 1, 1, 1).compareTo(SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 2, 2, 1, 1)));
        Assert.assertEquals(1, SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2).compareTo(SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 2)));
        Assert.assertEquals(0, SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2).compareTo(SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2)));
        Assert.assertEquals(-1, SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 2).compareTo(SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2)));
        Assert.assertEquals(1, SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2).compareTo(SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 3, 3)));
        Assert.assertEquals(-1, SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 3, 3).compareTo(SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 2, 2)));
    }

    @Test
    public void selectByOccurrences() {
        ImmutableSortedBag<Integer> ints = this.classUnderTest().selectByOccurrences(IntPredicates.isEven());
        Verify.assertAllSatisfy(ints, IntegerPredicates.isEven());
        ImmutableSortedBag<Integer> ints2 = this.classUnderTest().selectByOccurrences(IntPredicates.isOdd());
        Assert.assertEquals(ints2, this.classUnderTest());
    }

    @Test
    public void selectDuplicates() {
        Assert.assertEquals(Bags.immutable.with(1, 1, 1), this.classUnderTest().selectDuplicates());
    }

    @Test
    public void newWithTest() {
        ImmutableSortedBag<Integer> immutable = this.classUnderTest();
        immutable = immutable.newWith(4);
        // inserting at the beginning point (existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 1, 2, 4), immutable.newWith(1));
        // inserting at the middle point (existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 2, 2, 4), immutable.newWith(2));
        // inserting at the end point (existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 2, 4, 4), immutable.newWith(4));
        // inserting at the beginning point (not existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(0, 1, 1, 1, 2, 4), immutable.newWith(0));
        // inserting at the middle point (not existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 2, 3, 4), immutable.newWith(3));
        // inserting at the end point (not existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 2, 4, 5), immutable.newWith(5));
    }

    @Test
    public void newWithout() {
        ImmutableSortedBag<Integer> immutable = this.classUnderTest();
        immutable = immutable.newWith(4);
        // removing at the beginning point (existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 2, 4), immutable.newWithout(1));
        // removing at the middle point (existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 4), immutable.newWithout(2));
        // removing at the end point (existing element)
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 2), immutable.newWithout(4));
        // removing at the beginning point (not existing element)
        Assert.assertEquals(immutable, immutable.newWithout(0));
        // removing at the middle point (not existing element)
        Assert.assertEquals(immutable, immutable.newWithout(3));
        // removing at the end point (not existing element)
        Assert.assertEquals(immutable, immutable.newWithout(5));
    }

    @Test
    public void newWithAll() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest(Comparators.reverseNaturalOrder());
        ImmutableSortedBag<Integer> actualBag = bag.newWithAll(HashBag.newBagWith(3, 4));
        Assert.assertNotEquals(bag, actualBag);
        TreeBag<Integer> expectedBag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 3, 2, 1, 1, 1);
        Verify.assertSortedBagsEqual(expectedBag, actualBag);
        Assert.assertSame(expectedBag.comparator(), actualBag.comparator());
    }

    @Test
    public void toStringOfItemToCount() {
        Assert.assertEquals("{}", SortedBags.immutable.empty().toStringOfItemToCount());
        Assert.assertEquals("{1=3, 2=1}", this.classUnderTest().toStringOfItemToCount());
        Assert.assertEquals("{2=1, 1=3}", this.classUnderTest(Comparator.reverseOrder()).toStringOfItemToCount());
    }

    @Test
    public void newWithoutAll() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        ImmutableSortedBag<Integer> withoutAll = bag.newWithoutAll(bag);
        Assert.assertEquals(SortedBags.immutable.<Integer>empty(), withoutAll);
        Assert.assertEquals(Bags.immutable.<Integer>empty(), withoutAll);
        ImmutableSortedBag<Integer> largeWithoutAll = bag.newWithoutAll(Interval.fromTo(101, 150));
        Assert.assertEquals(bag, largeWithoutAll);
        ImmutableSortedBag<Integer> largeWithoutAll2 = bag.newWithoutAll(HashBag.newBag(Interval.fromTo(151, 199)));
        Assert.assertEquals(bag, largeWithoutAll2);
    }

    @Test
    public void size() {
        ImmutableSortedBag<Object> empty = SortedBags.immutable.empty();
        Assert.assertEquals(0, empty.size());
        ImmutableSortedBag<?> empty2 = SortedBags.immutable.empty(Comparators.reverseNaturalOrder());
        Assert.assertEquals(0, empty2.size());
        ImmutableSortedBag<Integer> integers = SortedBags.immutable.of(Comparator.reverseOrder(), 1, 2, 3, 4, 4, 4);
        Assert.assertEquals(6, integers.size());
        ImmutableSortedBag<Integer> integers2 = SortedBags.immutable.of(1, 2, 3, 4, 4, 4);
        Assert.assertEquals(6, integers2.size());
    }

    @Test
    public void contains() {
        ImmutableSortedBag<Integer> bag1 = this.classUnderTest();
        Verify.assertContains(1, bag1);
        Verify.assertContains(2, bag1);
        Verify.assertNotContains(Integer.valueOf(bag1.size() + 1), bag1.toSortedBag());
    }

    @Test
    public void containsAllArray() {
        ImmutableSortedBag<Integer> bag1 = this.classUnderTest();
        Assert.assertTrue(bag1.containsAllArguments(bag1.toArray()));
    }

    @Test
    public void containsAllIterable() {
        ImmutableSortedBag<Integer> bag1 = this.classUnderTest();
        Assert.assertTrue(bag1.containsAllIterable(FastList.newListWith(1, 1, 1, 2)));
        Assert.assertFalse(bag1.containsAllIterable(FastList.newListWith(50, 1, 1, 2)));
    }

    @Test
    public void containsAll() {
        ImmutableSortedBag<Integer> bag1 = this.classUnderTest();
        Assert.assertTrue(bag1.containsAll(FastList.newListWith(1, 1, 1, 2)));
        Assert.assertFalse(bag1.containsAll(FastList.newListWith(50, 1, 1, 2)));
    }

    @Override
    @Test
    public void tap() {
        MutableList<Integer> tapResult = Lists.mutable.empty();
        ImmutableSortedBag<Integer> collection = this.classUnderTest();
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    @Test
    public void forEach() {
        MutableBag<Integer> result = HashBag.newBag();
        ImmutableSortedBag<Integer> collection = this.classUnderTest();
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(collection, result);
    }

    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.empty();
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        bag.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Verify.assertListsEqual(result, bag.toList());
    }

    @Test
    public void forEachWithIndex() {
        MutableList<Integer> result = Lists.mutable.empty();
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        bag.forEachWithIndex((object, index) -> result.add(object));
        Verify.assertListsEqual(result, bag.toList());
    }

    @Override
    @Test
    public void toSortedSet() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableSortedSet<Integer> set = integers.toSortedSet();
        Assert.assertEquals(SortedSets.immutable.of(1, 2), set);
    }

    @Override
    @Test
    public void toSortedSetWithComparator() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        MutableSortedSet<Integer> set = integers.toSortedSet();
        ImmutableSortedSet<Integer> expected = SortedSets.immutable.of(Comparators.reverseNaturalOrder(), 1, 2);
        Assert.assertEquals(expected, set);
        Assert.assertNotSame(expected.comparator(), set.comparator());
        ImmutableSortedBag<Integer> integers2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        MutableSortedSet<Integer> set2 = integers2.toSortedSet(Comparators.reverseNaturalOrder());
        ImmutableSortedSet<Integer> expected2 = SortedSets.immutable.of(Comparators.reverseNaturalOrder(), 1, 2);
        Assert.assertEquals(expected2, set2);
        Assert.assertSame(expected2.comparator(), set2.comparator());
    }

    @Override
    @Test
    public void select() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Verify.assertIterableEmpty(integers.select(Predicates.greaterThan(integers.size())));
        TreeBag<Integer> expectedBag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2);
        ImmutableSortedBag<Integer> actualBag = integers.select(Predicates.lessThan(integers.size()));
        Verify.assertSortedBagsEqual(expectedBag, actualBag);
        Assert.assertSame(expectedBag.comparator(), actualBag.comparator());
    }

    @Override
    @Test
    public void selectWith() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Verify.assertIterableEmpty(integers.selectWith(Predicates2.greaterThan(), integers.size()));
        TreeBag<Integer> expectedBag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2);
        ImmutableSortedBag<Integer> actualBag = integers.selectWith(Predicates2.lessThan(), integers.size());
        Verify.assertSortedBagsEqual(expectedBag, actualBag);
        Assert.assertSame(expectedBag.comparator(), actualBag.comparator());
    }

    @Test
    public void selectToTarget() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Verify.assertListsEqual(integers.toList(), integers.select(Predicates.lessThan(integers.size() + 1), FastList.newList()));
        Verify.assertEmpty(integers.select(Predicates.greaterThan(integers.size()), FastList.newList()));
    }

    @Override
    @Test
    public void reject() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertEmpty(FastList.newList(integers.reject(Predicates.lessThan(integers.size() + 1))));
        Verify.assertSortedBagsEqual(integers, integers.reject(Predicates.greaterThan(integers.size())));
    }

    @Override
    @Test
    public void rejectWith() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Verify.assertIterableEmpty(integers.rejectWith(Predicates2.lessThanOrEqualTo(), integers.size()));
        TreeBag<Integer> expectedBag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2);
        ImmutableSortedBag<Integer> actualBag = integers.rejectWith(Predicates2.greaterThanOrEqualTo(), integers.size());
        Verify.assertSortedBagsEqual(expectedBag, actualBag);
        Assert.assertSame(expectedBag.comparator(), actualBag.comparator());
    }

    @Test
    public void rejectToTarget() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Verify.assertEmpty(integers.reject(Predicates.lessThan(integers.size() + 1), FastList.newList()));
        Verify.assertListsEqual(integers.toList(), integers.reject(Predicates.greaterThan(integers.size()), FastList.newList()));
        ImmutableSortedBag<Integer> integers2 = this.classUnderTest();
        Assert.assertEquals(HashBag.newBagWith(2), integers2.reject(each -> each == 1, new HashBag<>()));
    }

    @Override
    @Test
    public void selectInstancesOf() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(bag, bag.selectInstancesOf(Integer.class));
        Verify.assertIterableEmpty(bag.selectInstancesOf(Double.class));
        Assert.assertSame(bag.comparator(), bag.selectInstancesOf(Integer.class).comparator());
        Assert.assertSame(bag.comparator(), bag.selectInstancesOf(Double.class).comparator());
    }

    @Override
    @Test
    public void partition() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        PartitionImmutableSortedBag<Integer> partition1 = integers.partition(Predicates.greaterThan(integers.size()));
        Verify.assertIterableEmpty(partition1.getSelected());
        Assert.assertEquals(integers, partition1.getRejected());
        Assert.assertSame(integers.comparator(), partition1.getSelected().comparator());
        Assert.assertSame(integers.comparator(), partition1.getRejected().comparator());
        PartitionImmutableSortedBag<Integer> partition2 = integers.partition(integer -> integer % 2 == 0);
        Verify.assertSortedBagsEqual(integers.select(integer -> integer % 2 == 0), partition2.getSelected());
        Verify.assertSortedBagsEqual(integers.reject(integer -> integer % 2 == 0), partition2.getRejected());
        Assert.assertSame(integers.comparator(), partition2.getSelected().comparator());
        Assert.assertSame(integers.comparator(), partition2.getRejected().comparator());
    }

    @Override
    @Test
    public void partitionWith() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        PartitionImmutableSortedBag<Integer> partition1 = integers.partitionWith(Predicates2.greaterThan(), integers.size());
        Verify.assertIterableEmpty(partition1.getSelected());
        Assert.assertEquals(integers, partition1.getRejected());
        Assert.assertSame(integers.comparator(), partition1.getSelected().comparator());
        Assert.assertSame(integers.comparator(), partition1.getRejected().comparator());
        PartitionImmutableSortedBag<Integer> partition2 = integers.partitionWith((integer, divisor) -> integer % divisor == 0, 2);
        Verify.assertSortedBagsEqual(integers.select(integer -> integer % 2 == 0), partition2.getSelected());
        Verify.assertSortedBagsEqual(integers.reject(integer -> integer % 2 == 0), partition2.getRejected());
        Assert.assertSame(integers.comparator(), partition2.getSelected().comparator());
        Assert.assertSame(integers.comparator(), partition2.getRejected().comparator());
    }

    @Test
    public void partitionWhile() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        PartitionSortedBag<Integer> partition1 = integers.partitionWhile(Predicates.greaterThan(integers.size()));
        Verify.assertIterableEmpty(partition1.getSelected());
        Assert.assertEquals(integers, partition1.getRejected());
        Assert.assertSame(integers.comparator(), partition1.getSelected().comparator());
        Assert.assertSame(integers.comparator(), partition1.getRejected().comparator());
        PartitionSortedBag<Integer> partition2 = integers.partitionWhile(Predicates.lessThanOrEqualTo(integers.size()));
        Assert.assertEquals(integers, partition2.getSelected());
        Verify.assertIterableEmpty(partition2.getRejected());
        Assert.assertSame(integers.comparator(), partition2.getSelected().comparator());
        Assert.assertSame(integers.comparator(), partition2.getRejected().comparator());
    }

    @Test
    public void takeWhile() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedBag<Integer> take1 = integers.takeWhile(Predicates.greaterThan(integers.size()));
        Verify.assertIterableEmpty(take1);
        Assert.assertSame(integers.comparator(), take1.comparator());
        ImmutableSortedBag<Integer> take2 = integers.takeWhile(Predicates.lessThanOrEqualTo(integers.size()));
        Assert.assertEquals(integers, take2);
        Assert.assertSame(integers.comparator(), take2.comparator());
    }

    @Test
    public void dropWhile() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        ImmutableSortedBag<Integer> drop1 = integers.dropWhile(Predicates.greaterThan(integers.size()));
        Assert.assertEquals(integers, drop1);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), drop1.comparator());
        ImmutableSortedBag<Integer> drop2 = integers.dropWhile(Predicates.lessThanOrEqualTo(integers.size()));
        Verify.assertIterableEmpty(drop2);
        Assert.assertEquals(Collections.<Integer>reverseOrder(), drop2.comparator());
    }

    @Override
    @Test
    public void collect() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertListsEqual(integers.toList(), integers.collect(Functions.getIntegerPassThru()).castToList());
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableList<ObjectIntPair<Integer>> expected = Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(2), 0), PrimitiveTuples.pair(Integer.valueOf(1), 1), PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(1), 3));
        ImmutableList<ObjectIntPair<Integer>> actual = integers.collectWithIndex(PrimitiveTuples::pair);
        Assert.assertEquals(expected, actual);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableList<ObjectIntPair<Integer>> expected = Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(2), 0), PrimitiveTuples.pair(Integer.valueOf(1), 1), PrimitiveTuples.pair(Integer.valueOf(1), 2), PrimitiveTuples.pair(Integer.valueOf(1), 3));
        MutableList<ObjectIntPair<Integer>> actual = integers.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty());
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void collectWith() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        Verify.assertListsEqual(integers.toList(), integers.collectWith((value, parameter) -> value / parameter, 1).castToList());
    }

    @Test
    public void collectToTarget() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertEquals(HashBag.newBag(integers), integers.collect(Functions.getIntegerPassThru(), HashBag.newBag()));
        Verify.assertListsEqual(integers.toList(), integers.collect(Functions.getIntegerPassThru(), FastList.newList()));
    }

    @Override
    @Test
    public void flatCollect() {
        ImmutableList<String> actual = this.classUnderTest(Collections.reverseOrder()).flatCollect(integer -> Lists.fixedSize.of(String.valueOf(integer)));
        ImmutableList<String> expected = this.classUnderTest(Collections.reverseOrder()).collect(String::valueOf);
        Assert.assertEquals(expected, actual);
        Verify.assertListsEqual(expected.toList(), actual.toList());
    }

    @Test
    public void flatCollectWithTarget() {
        MutableBag<String> actual = this.classUnderTest().flatCollect(integer -> Lists.fixedSize.of(String.valueOf(integer)), HashBag.newBag());
        ImmutableList<String> expected = this.classUnderTest().collect(String::valueOf);
        Assert.assertEquals(expected.toBag(), actual);
    }

    @Test
    public void zip() {
        ImmutableSortedBag<Integer> immutableBag = this.classUnderTest(Collections.reverseOrder());
        List<Object> nulls = Collections.nCopies(immutableBag.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(immutableBag.size() + 1, null);
        List<Object> nullsMinusOne = Collections.nCopies(immutableBag.size() - 1, null);
        ImmutableList<Pair<Integer, Object>> pairs = immutableBag.zip(nulls);
        Assert.assertEquals(immutableBag.toList(), pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Verify.assertListsEqual(FastList.newListWith(2, 1, 1, 1), pairs.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne).toList());
        Assert.assertEquals(FastList.newList(nulls), pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableList<Pair<Integer, Object>> pairsPlusOne = immutableBag.zip(nullsPlusOne);
        Assert.assertEquals(immutableBag.toList(), pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne));
        Verify.assertListsEqual(FastList.newListWith(2, 1, 1, 1), pairsPlusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne).castToList());
        Assert.assertEquals(FastList.newList(nulls), pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo));
        ImmutableList<Pair<Integer, Object>> pairsMinusOne = immutableBag.zip(nullsMinusOne);
        Verify.assertListsEqual(FastList.newListWith(2, 1, 1), pairsMinusOne.collect((Function<Pair<Integer, ?>, Integer>) Pair::getOne).castToList());
        Assert.assertEquals(immutableBag.zip(nulls), immutableBag.zip(nulls, FastList.newList()));
        Assert.assertEquals(immutableBag.zip(nulls).toBag(), immutableBag.zip(nulls, new HashBag<>()));
        FastList<Holder> holders = FastList.newListWith(new Holder(1), new Holder(2), new Holder(3));
        ImmutableList<Pair<Integer, Holder>> zipped = immutableBag.zip(holders);
        Verify.assertSize(3, zipped.castToList());
        AbstractImmutableSortedBagTestCase.Holder two = new Holder(-1);
        AbstractImmutableSortedBagTestCase.Holder two1 = new Holder(-1);
        Assert.assertEquals(Tuples.pair(10, two1), zipped.newWith(Tuples.pair(10, two)).getLast());
        Assert.assertEquals(Tuples.pair(1, new Holder(3)), this.classUnderTest().zip(holders.reverseThis()).getFirst());
    }

    @Test
    public void zipWithIndex() {
        ImmutableSortedBag<Integer> integers = SortedBags.immutable.of(Collections.reverseOrder(), 1, 3, 5, 5, 5, 2, 4);
        ImmutableSortedSet<Pair<Integer, Integer>> expected = TreeSortedSet.newSetWith(Tuples.pair(5, 0), Tuples.pair(5, 1), Tuples.pair(5, 2), Tuples.pair(4, 3), Tuples.pair(3, 4), Tuples.pair(2, 5), Tuples.pair(1, 6)).toImmutable();
        ImmutableSortedSet<Pair<Integer, Integer>> actual = integers.zipWithIndex();
        Assert.assertEquals(expected, actual);
        ImmutableSortedBag<Integer> integersNoComparator = SortedBags.immutable.of(1, 3, 5, 5, 5, 2, 4);
        ImmutableSortedSet<Pair<Integer, Integer>> expected2 = TreeSortedSet.newSetWith(Tuples.pair(1, 0), Tuples.pair(2, 1), Tuples.pair(3, 2), Tuples.pair(4, 3), Tuples.pair(5, 4), Tuples.pair(5, 5), Tuples.pair(5, 6)).toImmutable();
        ImmutableSortedSet<Pair<Integer, Integer>> actual2 = integersNoComparator.zipWithIndex();
        Assert.assertEquals(expected2, actual2);
    }

    @Override
    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        this.classUnderTest().chunk(0);
    }

    @Test
    public void chunk_large_size() {
        Assert.assertEquals(this.classUnderTest(), this.classUnderTest().chunk(10).getFirst());
        Verify.assertInstanceOf(ImmutableSortedBag.class, this.classUnderTest().chunk(10).getFirst());
    }

    @Override
    @Test
    public void detect() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.detect(Predicates.equal(1)));
        Assert.assertNull(integers.detect(Predicates.equal(integers.size() + 1)));
    }

    @Override
    @Test
    public void detectWith() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.detectWith(Object::equals, Integer.valueOf(1)));
        Assert.assertNull(integers.detectWith(Object::equals, Integer.valueOf(integers.size() + 1)));
    }

    @Override
    @Test
    public void detectWithIfNone() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Function0<Integer> function = new PassThruFunction0<>(integers.size() + 1);
        Integer sum = Integer.valueOf(integers.size() + 1);
        Assert.assertEquals(Integer.valueOf(1), integers.detectWithIfNone(Object::equals, Integer.valueOf(1), function));
        Assert.assertEquals(Integer.valueOf(integers.size() + 1), integers.detectWithIfNone(Object::equals, sum, function));
    }

    @Override
    @Test
    public void detectIfNone() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Function0<Integer> function = new PassThruFunction0<>(integers.size() + 1);
        Assert.assertEquals(Integer.valueOf(1), integers.detectIfNone(Predicates.equal(1), function));
        Assert.assertEquals(Integer.valueOf(integers.size() + 1), integers.detectIfNone(Predicates.equal(integers.size() + 1), function));
    }

    @Override
    @Test
    public void allSatisfy() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertTrue(integers.allSatisfy(Integer.class::isInstance));
        Assert.assertFalse(integers.allSatisfy(Integer.valueOf(0)::equals));
    }

    @Override
    @Test
    public void anySatisfy() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertFalse(integers.anySatisfy(String.class::isInstance));
        Assert.assertTrue(integers.anySatisfy(Integer.class::isInstance));
    }

    @Override
    @Test
    public void count() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertEquals(integers.size(), integers.count(Integer.class::isInstance));
        Assert.assertEquals(0, integers.count(String.class::isInstance));
    }

    @Override
    @Test
    public void collectIf() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        ImmutableList<Integer> integers1 = integers.collectIf(Integer.class::isInstance, Functions.getIntegerPassThru());
        Verify.assertListsEqual(integers.toList(), integers1.toList());
    }

    @Test
    public void collectIfToTarget() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        HashBag<Integer> actual = integers.collectIf(Integer.class::isInstance, Functions.getIntegerPassThru(), HashBag.newBag());
        Assert.assertEquals(integers.toBag(), actual);
    }

    @Override
    @Test
    public void getFirst() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(1), integers.getFirst());
        ImmutableSortedBag<Integer> revInt = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Integer.valueOf(2), revInt.getFirst());
    }

    @Override
    @Test
    public void getLast() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Assert.assertEquals(Integer.valueOf(2), integers.getLast());
        ImmutableSortedBag<Integer> revInt = this.classUnderTest(Collections.reverseOrder());
        Assert.assertEquals(Integer.valueOf(1), revInt.getLast());
    }

    @Override
    @Test
    public void isEmpty() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertFalse(bag.isEmpty());
        Assert.assertTrue(bag.notEmpty());
    }

    @Override
    @Test
    public void iterator() {
        ImmutableSortedBag<Integer> integers = SortedBags.immutable.of(1, 2, 3, 4);
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

    @Override
    @Test
    public void injectInto() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        Integer result = integers.injectInto(0, AddFunction.INTEGER);
        Assert.assertEquals(FastList.newList(integers).injectInto(0, AddFunction.INTEGER_TO_INT), result.intValue());
    }

    @Override
    @Test
    public void toArray() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableList<Integer> copy = FastList.newList(integers);
        Assert.assertArrayEquals(integers.toArray(), copy.toArray());
        Assert.assertArrayEquals(integers.toArray(new Integer[integers.size()]), copy.toArray(new Integer[integers.size()]));
        Assert.assertArrayEquals(integers.toArray(new Integer[integers.size() - 1]), copy.toArray(new Integer[integers.size() - 1]));
        Assert.assertArrayEquals(integers.toArray(new Integer[integers.size() + 1]), copy.toArray(new Integer[integers.size() + 1]));
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals(FastList.newList(this.classUnderTest()).toString(), this.classUnderTest().toString());
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals(FastList.newList(this.classUnderTest()).makeString(), this.classUnderTest().makeString());
    }

    @Override
    @Test
    public void appendString() {
        Appendable builder = new StringBuilder();
        this.classUnderTest().appendString(builder);
        Assert.assertEquals(FastList.newList(this.classUnderTest()).makeString(), builder.toString());
    }

    @Test
    public void toList() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableList<Integer> list = integers.toList();
        Verify.assertEqualsAndHashCode(FastList.newList(integers), list);
    }

    @Override
    @Test
    public void toSortedList() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableList<Integer> copy = FastList.newList(integers);
        MutableList<Integer> list = integers.toSortedList(Collections.reverseOrder());
        Assert.assertEquals(copy.sortThis(Collections.reverseOrder()), list);
        MutableList<Integer> list2 = integers.toSortedList();
        Verify.assertListsEqual(copy.sortThis(), list2);
    }

    @Test
    public void toSortedListBy() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableList<Integer> list = integers.toSortedListBy(String::valueOf);
        Assert.assertEquals(integers.toList(), list);
    }

    @Test
    public void toSortedBag() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Collections.reverseOrder());
        MutableSortedBag<Integer> bag = integers.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 1, 2), bag);
    }

    @Test
    public void toSortedBagWithComparator() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableSortedBag<Integer> bag = integers.toSortedBag(Collections.reverseOrder());
        Assert.assertEquals(integers.toBag(), bag);
        Assert.assertEquals(integers.toSortedList(Comparators.reverseNaturalOrder()), bag.toList());
    }

    @Test
    public void toSortedBagBy() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableSortedBag<Integer> bag = integers.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBag(integers), bag);
    }

    @Test
    public void toSortedMap() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableSortedMap<Integer, String> map = integers.toSortedMap(Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertMapsEqual(integers.toMap(Functions.getIntegerPassThru(), String::valueOf), map);
        Verify.assertListsEqual(FastList.newListWith(1, 2), map.keySet().toList());
    }

    @Test
    public void toSortedMap_with_comparator() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableSortedMap<Integer, String> map = integers.toSortedMap(Comparators.reverseNaturalOrder(), Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertMapsEqual(integers.toMap(Functions.getIntegerPassThru(), String::valueOf), map);
        Verify.assertListsEqual(FastList.newListWith(2, 1), map.keySet().toList());
    }

    @Test
    public void toSortedMapBy() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest();
        MutableSortedMap<Integer, String> map = integers.toSortedMapBy(key -> -key, Functions.getIntegerPassThru(), String::valueOf);
        Verify.assertMapsEqual(integers.toMap(Functions.getIntegerPassThru(), String::valueOf), map);
        Verify.assertListsEqual(FastList.newListWith(2, 1), map.keySet().toList());
    }

    @Override
    @Test
    public void forLoop() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        for (Integer each : bag) {
            Assert.assertNotNull(each);
        }
    }

    @Test
    public void toMapOfItemToCount() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Collections.reverseOrder(), 1, 2, 2, 3, 3, 3);
        MutableSortedMap<Integer, Integer> expected = TreeSortedMap.newMapWith(Collections.reverseOrder(), 1, 1, 2, 2, 3, 3);
        MutableSortedMap<Integer, Integer> actual = bag.toMapOfItemToCount();
        Assert.assertEquals(expected, actual);
        Assert.assertSame(bag.comparator(), actual.comparator());
    }

    @Override
    @Test
    public void min() {
        Assert.assertEquals(Integer.valueOf(2), this.classUnderTest().min(Comparators.reverseNaturalOrder()));
    }

    @Override
    @Test
    public void max() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().max(Comparators.reverseNaturalOrder()));
    }

    @Override
    @Test
    public void min_without_comparator() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().min());
    }

    @Override
    @Test
    public void max_without_comparator() {
        Assert.assertEquals(Integer.valueOf(2), this.classUnderTest().max());
    }

    @Override
    @Test
    public void minBy() {
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest().minBy(String::valueOf));
        Assert.assertEquals(Integer.valueOf(1), this.classUnderTest(Comparator.reverseOrder()).minBy(String::valueOf));
    }

    @Override
    @Test
    public void maxBy() {
        Assert.assertEquals(Integer.valueOf(2), this.classUnderTest().maxBy(String::valueOf));
    }

    @Test
    public void groupBy() {
        ImmutableSortedBag<Integer> undertest = this.classUnderTest(Comparators.reverseNaturalOrder());
        ImmutableSortedBagMultimap<Integer, Integer> actual = undertest.groupBy(Functions.getPassThru());
        ImmutableSortedBagMultimap<Integer, Integer> expected = TreeBag.newBag(undertest).groupBy(Functions.getPassThru()).toImmutable();
        Assert.assertEquals(expected, actual);
        Assert.assertSame(Comparators.reverseNaturalOrder(), actual.comparator());
    }

    @Test
    public void groupByEach() {
        ImmutableSortedBag<Integer> undertest = this.classUnderTest(Collections.reverseOrder());
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        ImmutableSortedBagMultimap<Integer, Integer> actual = undertest.groupByEach(function);
        ImmutableSortedBagMultimap<Integer, Integer> expected = TreeBag.newBag(undertest).groupByEach(function).toImmutable();
        Assert.assertEquals(expected, actual);
        Assert.assertSame(Collections.reverseOrder(), actual.comparator());
    }

    @Test
    public void groupByWithTarget() {
        ImmutableSortedBag<Integer> undertest = this.classUnderTest(Comparators.reverseNaturalOrder());
        TreeBagMultimap<Integer, Integer> actual = undertest.groupBy(Functions.getPassThru(), TreeBagMultimap.newMultimap());
        TreeBagMultimap<Integer, Integer> expected = TreeBag.newBag(undertest).groupBy(Functions.getPassThru());
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByEachWithTarget() {
        ImmutableSortedBag<Integer> undertest = this.classUnderTest();
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        TreeBagMultimap<Integer, Integer> actual = undertest.groupByEach(function, TreeBagMultimap.newMultimap());
        TreeBagMultimap<Integer, Integer> expected = TreeBag.newBag(undertest).groupByEach(function);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void groupByUniqueKey() {
        ImmutableSortedBag<Integer> bag1 = this.newWith(1, 2, 3);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), bag1.groupByUniqueKey(id -> id));
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertThrows(IllegalStateException.class, () -> bag2.groupByUniqueKey(id -> id));
    }

    @Test
    public void groupByUniqueKey_target() {
        ImmutableSortedBag<Integer> bag1 = this.newWith(1, 2, 3);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3), bag1.groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(0, 0)));
        ImmutableSortedBag<Integer> bag2 = this.newWith(1, 2, 3);
        Assert.assertThrows(IllegalStateException.class, () -> bag2.groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(2, 2)));
    }

    @Test
    public void distinct() {
        ImmutableSortedBag<Integer> bag1 = this.classUnderTest();
        Assert.assertEquals(SortedSets.immutable.of(1, 2), bag1.distinct());
        ImmutableSortedBag<Integer> bag2 = this.classUnderTest(Comparators.reverseNaturalOrder());
        ImmutableSortedSet<Integer> expected = SortedSets.immutable.of(Comparators.reverseNaturalOrder(), 1, 2);
        ImmutableSortedSet<Integer> actual = bag2.distinct();
        Assert.assertEquals(expected, actual);
        Assert.assertSame(expected.comparator(), actual.comparator());
    }

    @Test
    public void toStack() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(ArrayStack.newStackWith(2, 1, 1, 1), bag.toStack());
    }

    @Override
    @Test
    public void collectBoolean() {
        ImmutableSortedBag<String> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), "true", "nah", "TrUe");
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), bag.collectBoolean(Boolean::parseBoolean));
    }

    @Override
    @Test
    public void collectByte() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1, (byte) 1, (byte) 1), bag.collectByte(PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Override
    @Test
    public void collectChar() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 2, (char) 1, (char) 1, (char) 1), bag.collectChar(PrimitiveFunctions.unboxIntegerToChar()));
    }

    @Override
    @Test
    public void collectDouble() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(DoubleArrayList.newListWith(3, 2, 1, 1, 1), bag.collectDouble(PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Override
    @Test
    public void collectFloat() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(FloatArrayList.newListWith(3, 2, 1, 1, 1), bag.collectFloat(PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Override
    @Test
    public void collectInt() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(IntArrayList.newListWith(3, 2, 1, 1, 1), bag.collectInt(PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Override
    @Test
    public void collectLong() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(LongArrayList.newListWith(3, 2, 1, 1, 1), bag.collectLong(PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Override
    @Test
    public void collectShort() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 2, (short) 1, (short) 1, (short) 1), bag.collectShort(PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Test
    public void collectBoolean_target() {
        ImmutableSortedBag<String> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), "true", "nah", "TrUe");
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), bag.collectBoolean(Boolean::parseBoolean, new BooleanArrayList()));
        ImmutableSortedBag<String> bag2 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), "true", "nah", "TrUe");
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, true), bag2.collectBoolean(Boolean::parseBoolean, new BooleanHashBag()));
    }

    @Test
    public void collectByte_target() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1, (byte) 1, (byte) 1), bag.collectByte(PrimitiveFunctions.unboxIntegerToByte(), new ByteArrayList()));
        ImmutableSortedBag<Integer> bag2 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 3, (byte) 2, (byte) 1, (byte) 1, (byte) 1), bag2.collectByte(PrimitiveFunctions.unboxIntegerToByte(), new ByteHashBag()));
    }

    @Test
    public void collectChar_target() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 2, (char) 1, (char) 1, (char) 1), bag.collectChar(PrimitiveFunctions.unboxIntegerToChar(), new CharArrayList()));
        ImmutableSortedBag<Integer> bag2 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(CharHashBag.newBagWith((char) 3, (char) 2, (char) 1, (char) 1, (char) 1), bag2.collectChar(PrimitiveFunctions.unboxIntegerToChar(), new CharHashBag()));
    }

    @Test
    public void collectDouble_target() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(DoubleArrayList.newListWith(3, 2, 1, 1, 1), bag.collectDouble(PrimitiveFunctions.unboxIntegerToDouble(), new DoubleArrayList()));
        ImmutableSortedBag<Integer> bag2 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(DoubleHashBag.newBagWith(3, 2, 1, 1, 1), bag2.collectDouble(PrimitiveFunctions.unboxIntegerToDouble(), new DoubleHashBag()));
    }

    @Test
    public void collectFloat_target() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(FloatArrayList.newListWith(3, 2, 1, 1, 1), bag.collectFloat(PrimitiveFunctions.unboxIntegerToFloat(), new FloatArrayList()));
        ImmutableSortedBag<Integer> bag2 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(FloatHashBag.newBagWith(3, 2, 1, 1, 1), bag2.collectFloat(PrimitiveFunctions.unboxIntegerToFloat(), new FloatHashBag()));
    }

    @Test
    public void collectInt_target() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(IntArrayList.newListWith(3, 2, 1, 1, 1), bag.collectInt(PrimitiveFunctions.unboxIntegerToInt(), new IntArrayList()));
        ImmutableSortedBag<Integer> bag2 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(IntHashBag.newBagWith(3, 2, 1, 1, 1), bag2.collectInt(PrimitiveFunctions.unboxIntegerToInt(), new IntHashBag()));
    }

    @Test
    public void collectLong_target() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(LongArrayList.newListWith(3, 2, 1, 1, 1), bag.collectLong(PrimitiveFunctions.unboxIntegerToLong(), new LongArrayList()));
        ImmutableSortedBag<Integer> bag2 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(LongHashBag.newBagWith(3, 2, 1, 1, 1), bag2.collectLong(PrimitiveFunctions.unboxIntegerToLong(), new LongHashBag()));
    }

    @Test
    public void collectShort_target() {
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 2, (short) 1, (short) 1, (short) 1), bag.collectShort(PrimitiveFunctions.unboxIntegerToShort(), new ShortArrayList()));
        ImmutableSortedBag<Integer> bag2 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 3, (short) 2, (short) 1, (short) 1, (short) 1), bag2.collectShort(PrimitiveFunctions.unboxIntegerToShort(), new ShortHashBag()));
    }

    @Test
    public void occurrencesOf() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        Assert.assertEquals(0, bag.occurrencesOf(5));
        Assert.assertEquals(3, bag.occurrencesOf(1));
        Assert.assertEquals(1, bag.occurrencesOf(2));
    }

    @Test
    public void toImmutable() {
        ImmutableSortedBag<Integer> bag = this.classUnderTest();
        ImmutableSortedBag<Integer> actual = bag.toImmutable();
        Assert.assertEquals(bag, actual);
        Assert.assertSame(bag, actual);
    }

    @Test
    public void forEachFromTo() {
        MutableSortedBag<Integer> integersMutable = SortedBags.mutable.of(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        ImmutableSortedBag<Integer> integers1 = integersMutable.toImmutable();
        MutableList<Integer> result = Lists.mutable.empty();
        integers1.forEach(5, 7, result::add);
        Assert.assertEquals(Lists.immutable.with(3, 3, 2), result);
        MutableList<Integer> result2 = Lists.mutable.empty();
        integers1.forEach(5, 5, result2::add);
        Assert.assertEquals(Lists.immutable.with(3), result2);
        MutableList<Integer> result3 = Lists.mutable.empty();
        integers1.forEach(0, 9, result3::add);
        Assert.assertEquals(Lists.immutable.with(4, 4, 4, 4, 3, 3, 3, 2, 2, 1), result3);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers1.forEach(-1, 0, result::add));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers1.forEach(0, -1, result::add));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers1.forEach(7, 5, result::add));
        ImmutableSortedBag<Integer> integers2 = this.classUnderTest();
        MutableList<Integer> mutableList = Lists.mutable.of();
        integers2.forEach(0, integers2.size() - 1, mutableList::add);
        Assert.assertEquals(this.classUnderTest().toList(), mutableList);
    }

    @Test
    public void forEachWithIndexWithFromTo() {
        ImmutableSortedBag<Integer> integers1 = SortedBags.immutable.of(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        StringBuilder builder = new StringBuilder();
        integers1.forEachWithIndex(5, 7, (each, index) -> builder.append(each).append(index));
        Assert.assertEquals("353627", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        integers1.forEachWithIndex(5, 5, (each, index) -> builder2.append(each).append(index));
        Assert.assertEquals("35", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        integers1.forEachWithIndex(0, 9, (each, index) -> builder3.append(each).append(index));
        Assert.assertEquals("40414243343536272819", builder3.toString());
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers1.forEachWithIndex(-1, 0, new AddToList(Lists.mutable.empty())));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers1.forEachWithIndex(0, -1, new AddToList(Lists.mutable.empty())));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers1.forEachWithIndex(7, 5, new AddToList(Lists.mutable.empty())));
        ImmutableSortedBag<Integer> integers2 = this.classUnderTest();
        MutableList<Integer> mutableList1 = Lists.mutable.of();
        integers2.forEachWithIndex(0, integers2.size() - 1, (each, index) -> mutableList1.add(each + index));
        MutableList<Integer> result = Lists.mutable.of();
        Lists.mutable.ofAll(integers2).forEachWithIndex(0, integers2.size() - 1, (each, index) -> result.add(each + index));
        Assert.assertEquals(result, mutableList1);
    }

    @Test
    public void topOccurrences() {
        ImmutableSortedBag<String> strings = this.newWithOccurrences(PrimitiveTuples.pair("one", 1), PrimitiveTuples.pair("two", 2), PrimitiveTuples.pair("three", 3), PrimitiveTuples.pair("four", 4), PrimitiveTuples.pair("five", 5), PrimitiveTuples.pair("six", 6), PrimitiveTuples.pair("seven", 7), PrimitiveTuples.pair("eight", 8), PrimitiveTuples.pair("nine", 9), PrimitiveTuples.pair("ten", 10));
        ListIterable<ObjectIntPair<String>> top5 = strings.topOccurrences(5);
        Assert.assertEquals(5, top5.size());
        Assert.assertEquals("ten", top5.getFirst().getOne());
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals("six", top5.getLast().getOne());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Assert.assertEquals(0, this.newWith().topOccurrences(5).size());
        Assert.assertEquals(3, this.newWith("one", "two", "three").topOccurrences(5).size());
        Assert.assertEquals(3, this.newWith("one", "two", "three").topOccurrences(1).size());
        Assert.assertEquals(3, this.newWith("one", "two", "three").topOccurrences(2).size());
        Assert.assertEquals(3, this.newWith("one", "one", "two", "three").topOccurrences(2).size());
        Assert.assertEquals(2, this.newWith("one", "one", "two", "two", "three").topOccurrences(1).size());
        Assert.assertEquals(3, this.newWith("one", "one", "two", "two", "three", "three").topOccurrences(1).size());
        Assert.assertEquals(0, this.newWith().topOccurrences(0).size());
        Assert.assertEquals(0, this.newWith("one").topOccurrences(0).size());
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void bottomOccurrences() {
        ImmutableSortedBag<String> strings = this.newWithOccurrences(PrimitiveTuples.pair("one", 1), PrimitiveTuples.pair("two", 2), PrimitiveTuples.pair("three", 3), PrimitiveTuples.pair("four", 4), PrimitiveTuples.pair("five", 5), PrimitiveTuples.pair("six", 6), PrimitiveTuples.pair("seven", 7), PrimitiveTuples.pair("eight", 8), PrimitiveTuples.pair("nine", 9), PrimitiveTuples.pair("ten", 10));
        ListIterable<ObjectIntPair<String>> bottom5 = strings.bottomOccurrences(5);
        Assert.assertEquals(5, bottom5.size());
        Assert.assertEquals("one", bottom5.getFirst().getOne());
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals("five", bottom5.getLast().getOne());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Assert.assertEquals(0, this.newWith().bottomOccurrences(5).size());
        Assert.assertEquals(3, this.newWith("one", "two", "three").topOccurrences(5).size());
        Assert.assertEquals(3, this.newWith("one", "two", "three").topOccurrences(1).size());
        Assert.assertEquals(3, this.newWith("one", "two", "three").topOccurrences(2).size());
        Assert.assertEquals(3, this.newWith("one", "one", "two", "three").topOccurrences(2).size());
        Assert.assertEquals(2, this.newWith("one", "one", "two", "two", "three").topOccurrences(1).size());
        Assert.assertEquals(3, this.newWith("one", "one", "two", "two", "three", "three").bottomOccurrences(1).size());
        Assert.assertEquals(0, this.newWith().bottomOccurrences(0).size());
        Assert.assertEquals(0, this.newWith("one").bottomOccurrences(0).size());
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void corresponds() {
        Assert.assertFalse(this.newWith(1, 2, 3, 4, 5).corresponds(this.newWith(1, 2, 3, 4), Predicates2.alwaysTrue()));
        ImmutableSortedBag<Integer> integers1 = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        MutableList<Integer> integers2 = FastList.newListWith(2, 3, 3, 4, 4, 4, 5, 5, 5, 5);
        Assert.assertTrue(integers1.corresponds(integers2, Predicates2.lessThan()));
        Assert.assertFalse(integers1.corresponds(integers2, Predicates2.greaterThan()));
        ImmutableSortedBag<Integer> integers3 = this.newWith(1, 2, 3, 4);
        MutableSortedSet<Integer> integers4 = SortedSets.mutable.of(2, 3, 4, 5);
        Assert.assertTrue(integers1.corresponds(integers2, Predicates2.lessThan()));
        Assert.assertFalse(integers3.corresponds(integers4, Predicates2.greaterThan()));
        Assert.assertTrue(integers3.corresponds(integers4, Predicates2.lessThan()));
    }

    @Test
    public void detectIndex() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(0, integers.detectIndex(each -> each == 2));
        ImmutableSortedBag<Integer> integers2 = this.classUnderTest();
        Assert.assertEquals(-1, integers2.detectIndex(each -> each == 100));
    }

    @Test
    public void indexOf() {
        ImmutableSortedBag<Integer> integers = this.classUnderTest(Comparators.reverseNaturalOrder());
        Assert.assertEquals(1, integers.indexOf(1));
        Assert.assertEquals(1, integers.indexOf(1));
        Assert.assertEquals(0, integers.indexOf(2));
        Assert.assertEquals(-1, integers.indexOf(0));
        Assert.assertEquals(-1, integers.indexOf(5));
    }

    @Test
    public void take() {
        ImmutableSortedBag<Integer> integers1 = this.classUnderTest();
        Assert.assertEquals(SortedBags.immutable.empty(integers1.comparator()), integers1.take(0));
        Assert.assertSame(integers1.comparator(), integers1.take(0).comparator());
        Assert.assertEquals(this.newWith(integers1.comparator(), 1, 1, 1), integers1.take(3));
        Assert.assertSame(integers1.comparator(), integers1.take(3).comparator());
        Assert.assertEquals(this.newWith(integers1.comparator(), 1, 1, 1), integers1.take(integers1.size() - 1));
        ImmutableSortedBag<Integer> integers2 = this.newWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
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
        ImmutableSortedBag<Integer> integers1 = this.classUnderTest();
        Assert.assertSame(integers1, integers1.drop(0));
        Assert.assertEquals(this.newWith(integers1.comparator(), 2), integers1.drop(3));
        Assert.assertEquals(this.newWith(integers1.comparator(), 2), integers1.drop(integers1.size() - 1));
        Assert.assertEquals(SortedBags.immutable.empty(integers1.comparator()), integers1.drop(integers1.size()));
        Assert.assertEquals(SortedBags.immutable.empty(integers1.comparator()), integers1.drop(10));
        Assert.assertEquals(SortedBags.immutable.empty(integers1.comparator()), integers1.drop(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_throws() {
        this.classUnderTest().drop(-1);
    }

    @Test
    public void selectUnique() {
        Comparator<Integer> comparator = Collections.reverseOrder();
        ImmutableSortedBag<Integer> bag = SortedBags.immutable.with(comparator, 5, 4, 3, 3, 2, 2, 2, 1, 1, 1, 1, 0);
        ImmutableSortedSet<Integer> expected = SortedSets.immutable.with(comparator, 5, 4, 0);
        ImmutableSortedSet<Integer> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected.comparator(), actual.comparator());
    }

    @Test
    public void distinctView() {
        Comparator<Integer> comparator = Collections.reverseOrder();
        ImmutableSortedBag<Integer> bag = this.classUnderTest(comparator);
        RichIterable<Integer> expected = bag.toSortedSet(comparator);
        RichIterable<Integer> actual = bag.distinctView();
        // test content/type
        Assert.assertEquals(expected, actual);
        // test sorting
        Verify.assertIterablesEqual(expected, actual);
    }

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

        private AbstractImmutableSortedBagTestCase instance;

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
        public void benchmark_countByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.countByEach);
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
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
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
        public void benchmark_newWithTest() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newWithTest);
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
        public void benchmark_size() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.size);
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
        public void benchmark_containsAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAll);
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
        public void benchmark_rejectToTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectToTarget);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
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
        public void benchmark_toSortedBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag);
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
        public void benchmark_forLoop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forLoop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
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
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
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
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
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
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
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
        public void benchmark_corresponds() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.corresponds);
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
        public void benchmark_take() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_take_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.take_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_drop_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.drop_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractImmutableSortedBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> stream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> parallelStream;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> castToCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collect_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> remove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> noSupportForNull;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> newWithTest;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> newWithout;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> newWithAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> newWithoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> containsAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedSetWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> selectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> rejectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> flatCollectWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> detectWithIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectIfToTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedBagWithComparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> forLoop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> groupByWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> groupByEachWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectBoolean_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectByte_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectChar_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectDouble_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectFloat_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectInt_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectLong_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> collectShort_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractImmutableSortedBagTestCase> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.stream = AbstractImmutableSortedBagTestCase::stream;
            this.payloads.parallelStream = AbstractImmutableSortedBagTestCase::parallelStream;
            this.payloads.castToCollection = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::castToCollection, java.lang.UnsupportedOperationException.class);
            this.payloads.countBy = AbstractImmutableSortedBagTestCase::countBy;
            this.payloads.countByWith = AbstractImmutableSortedBagTestCase::countByWith;
            this.payloads.countByEach = AbstractImmutableSortedBagTestCase::countByEach;
            this.payloads.selectWith_target = AbstractImmutableSortedBagTestCase::selectWith_target;
            this.payloads.rejectWith_target = AbstractImmutableSortedBagTestCase::rejectWith_target;
            this.payloads.collect_target = AbstractImmutableSortedBagTestCase::collect_target;
            this.payloads.collectWith_target = AbstractImmutableSortedBagTestCase::collectWith_target;
            this.payloads.injectIntoInt = AbstractImmutableSortedBagTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractImmutableSortedBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractImmutableSortedBagTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractImmutableSortedBagTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractImmutableSortedBagTestCase::sumFloat;
            this.payloads.sumDouble = AbstractImmutableSortedBagTestCase::sumDouble;
            this.payloads.sumInteger = AbstractImmutableSortedBagTestCase::sumInteger;
            this.payloads.sumLong = AbstractImmutableSortedBagTestCase::sumLong;
            this.payloads.sumByInt = AbstractImmutableSortedBagTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractImmutableSortedBagTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractImmutableSortedBagTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractImmutableSortedBagTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractImmutableSortedBagTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractImmutableSortedBagTestCase::sumByDoubleConsistentRounding;
            this.payloads.flatCollectWith = AbstractImmutableSortedBagTestCase::flatCollectWith;
            this.payloads.allSatisfyWith = AbstractImmutableSortedBagTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractImmutableSortedBagTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractImmutableSortedBagTestCase::noneSatisfyWith;
            this.payloads.anySatisfyWith = AbstractImmutableSortedBagTestCase::anySatisfyWith;
            this.payloads.countWith = AbstractImmutableSortedBagTestCase::countWith;
            this.payloads.toSortedSetBy = AbstractImmutableSortedBagTestCase::toSortedSetBy;
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.iteratorRemove = AbstractImmutableSortedBagTestCase::iteratorRemove;
            this.payloads.add = AbstractImmutableSortedBagTestCase::add;
            this.payloads.remove = AbstractImmutableSortedBagTestCase::remove;
            this.payloads.clear = AbstractImmutableSortedBagTestCase::clear;
            this.payloads.removeAll = AbstractImmutableSortedBagTestCase::removeAll;
            this.payloads.retainAll = AbstractImmutableSortedBagTestCase::retainAll;
            this.payloads.addAll = AbstractImmutableSortedBagTestCase::addAll;
            this.payloads.aggregateByMutating = AbstractImmutableSortedBagTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractImmutableSortedBagTestCase::aggregateByNonMutating;
            this.payloads.noSupportForNull = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::noSupportForNull, java.lang.NullPointerException.class);
            this.payloads.equalsAndHashCode = AbstractImmutableSortedBagTestCase::equalsAndHashCode;
            this.payloads.anySatisfyWithOccurrences = AbstractImmutableSortedBagTestCase::anySatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = AbstractImmutableSortedBagTestCase::allSatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = AbstractImmutableSortedBagTestCase::noneSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = AbstractImmutableSortedBagTestCase::detectWithOccurrences;
            this.payloads.compareTo = AbstractImmutableSortedBagTestCase::compareTo;
            this.payloads.selectByOccurrences = AbstractImmutableSortedBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = AbstractImmutableSortedBagTestCase::selectDuplicates;
            this.payloads.newWithTest = AbstractImmutableSortedBagTestCase::newWithTest;
            this.payloads.newWithout = AbstractImmutableSortedBagTestCase::newWithout;
            this.payloads.newWithAll = AbstractImmutableSortedBagTestCase::newWithAll;
            this.payloads.toStringOfItemToCount = AbstractImmutableSortedBagTestCase::toStringOfItemToCount;
            this.payloads.newWithoutAll = AbstractImmutableSortedBagTestCase::newWithoutAll;
            this.payloads.size = AbstractImmutableSortedBagTestCase::size;
            this.payloads.contains = AbstractImmutableSortedBagTestCase::contains;
            this.payloads.containsAllArray = AbstractImmutableSortedBagTestCase::containsAllArray;
            this.payloads.containsAllIterable = AbstractImmutableSortedBagTestCase::containsAllIterable;
            this.payloads.containsAll = AbstractImmutableSortedBagTestCase::containsAll;
            this.payloads.tap = AbstractImmutableSortedBagTestCase::tap;
            this.payloads.forEach = AbstractImmutableSortedBagTestCase::forEach;
            this.payloads.forEachWith = AbstractImmutableSortedBagTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractImmutableSortedBagTestCase::forEachWithIndex;
            this.payloads.toSortedSet = AbstractImmutableSortedBagTestCase::toSortedSet;
            this.payloads.toSortedSetWithComparator = AbstractImmutableSortedBagTestCase::toSortedSetWithComparator;
            this.payloads.select = AbstractImmutableSortedBagTestCase::select;
            this.payloads.selectWith = AbstractImmutableSortedBagTestCase::selectWith;
            this.payloads.selectToTarget = AbstractImmutableSortedBagTestCase::selectToTarget;
            this.payloads.reject = AbstractImmutableSortedBagTestCase::reject;
            this.payloads.rejectWith = AbstractImmutableSortedBagTestCase::rejectWith;
            this.payloads.rejectToTarget = AbstractImmutableSortedBagTestCase::rejectToTarget;
            this.payloads.selectInstancesOf = AbstractImmutableSortedBagTestCase::selectInstancesOf;
            this.payloads.partition = AbstractImmutableSortedBagTestCase::partition;
            this.payloads.partitionWith = AbstractImmutableSortedBagTestCase::partitionWith;
            this.payloads.partitionWhile = AbstractImmutableSortedBagTestCase::partitionWhile;
            this.payloads.takeWhile = AbstractImmutableSortedBagTestCase::takeWhile;
            this.payloads.dropWhile = AbstractImmutableSortedBagTestCase::dropWhile;
            this.payloads.collect = AbstractImmutableSortedBagTestCase::collect;
            this.payloads.collectWithIndex = AbstractImmutableSortedBagTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractImmutableSortedBagTestCase::collectWithIndexWithTarget;
            this.payloads.collectWith = AbstractImmutableSortedBagTestCase::collectWith;
            this.payloads.collectToTarget = AbstractImmutableSortedBagTestCase::collectToTarget;
            this.payloads.flatCollect = AbstractImmutableSortedBagTestCase::flatCollect;
            this.payloads.flatCollectWithTarget = AbstractImmutableSortedBagTestCase::flatCollectWithTarget;
            this.payloads.zip = AbstractImmutableSortedBagTestCase::zip;
            this.payloads.zipWithIndex = AbstractImmutableSortedBagTestCase::zipWithIndex;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractImmutableSortedBagTestCase::chunk_large_size;
            this.payloads.detect = AbstractImmutableSortedBagTestCase::detect;
            this.payloads.detectWith = AbstractImmutableSortedBagTestCase::detectWith;
            this.payloads.detectWithIfNone = AbstractImmutableSortedBagTestCase::detectWithIfNone;
            this.payloads.detectIfNone = AbstractImmutableSortedBagTestCase::detectIfNone;
            this.payloads.allSatisfy = AbstractImmutableSortedBagTestCase::allSatisfy;
            this.payloads.anySatisfy = AbstractImmutableSortedBagTestCase::anySatisfy;
            this.payloads.count = AbstractImmutableSortedBagTestCase::count;
            this.payloads.collectIf = AbstractImmutableSortedBagTestCase::collectIf;
            this.payloads.collectIfToTarget = AbstractImmutableSortedBagTestCase::collectIfToTarget;
            this.payloads.getFirst = AbstractImmutableSortedBagTestCase::getFirst;
            this.payloads.getLast = AbstractImmutableSortedBagTestCase::getLast;
            this.payloads.isEmpty = AbstractImmutableSortedBagTestCase::isEmpty;
            this.payloads.iterator = AbstractImmutableSortedBagTestCase::iterator;
            this.payloads.injectInto = AbstractImmutableSortedBagTestCase::injectInto;
            this.payloads.toArray = AbstractImmutableSortedBagTestCase::toArray;
            this.payloads.testToString = AbstractImmutableSortedBagTestCase::testToString;
            this.payloads.makeString = AbstractImmutableSortedBagTestCase::makeString;
            this.payloads.appendString = AbstractImmutableSortedBagTestCase::appendString;
            this.payloads.toList = AbstractImmutableSortedBagTestCase::toList;
            this.payloads.toSortedList = AbstractImmutableSortedBagTestCase::toSortedList;
            this.payloads.toSortedListBy = AbstractImmutableSortedBagTestCase::toSortedListBy;
            this.payloads.toSortedBag = AbstractImmutableSortedBagTestCase::toSortedBag;
            this.payloads.toSortedBagWithComparator = AbstractImmutableSortedBagTestCase::toSortedBagWithComparator;
            this.payloads.toSortedBagBy = AbstractImmutableSortedBagTestCase::toSortedBagBy;
            this.payloads.toSortedMap = AbstractImmutableSortedBagTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractImmutableSortedBagTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractImmutableSortedBagTestCase::toSortedMapBy;
            this.payloads.forLoop = AbstractImmutableSortedBagTestCase::forLoop;
            this.payloads.toMapOfItemToCount = AbstractImmutableSortedBagTestCase::toMapOfItemToCount;
            this.payloads.min = AbstractImmutableSortedBagTestCase::min;
            this.payloads.max = AbstractImmutableSortedBagTestCase::max;
            this.payloads.min_without_comparator = AbstractImmutableSortedBagTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractImmutableSortedBagTestCase::max_without_comparator;
            this.payloads.minBy = AbstractImmutableSortedBagTestCase::minBy;
            this.payloads.maxBy = AbstractImmutableSortedBagTestCase::maxBy;
            this.payloads.groupBy = AbstractImmutableSortedBagTestCase::groupBy;
            this.payloads.groupByEach = AbstractImmutableSortedBagTestCase::groupByEach;
            this.payloads.groupByWithTarget = AbstractImmutableSortedBagTestCase::groupByWithTarget;
            this.payloads.groupByEachWithTarget = AbstractImmutableSortedBagTestCase::groupByEachWithTarget;
            this.payloads.groupByUniqueKey = AbstractImmutableSortedBagTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_target = AbstractImmutableSortedBagTestCase::groupByUniqueKey_target;
            this.payloads.distinct = AbstractImmutableSortedBagTestCase::distinct;
            this.payloads.toStack = AbstractImmutableSortedBagTestCase::toStack;
            this.payloads.collectBoolean = AbstractImmutableSortedBagTestCase::collectBoolean;
            this.payloads.collectByte = AbstractImmutableSortedBagTestCase::collectByte;
            this.payloads.collectChar = AbstractImmutableSortedBagTestCase::collectChar;
            this.payloads.collectDouble = AbstractImmutableSortedBagTestCase::collectDouble;
            this.payloads.collectFloat = AbstractImmutableSortedBagTestCase::collectFloat;
            this.payloads.collectInt = AbstractImmutableSortedBagTestCase::collectInt;
            this.payloads.collectLong = AbstractImmutableSortedBagTestCase::collectLong;
            this.payloads.collectShort = AbstractImmutableSortedBagTestCase::collectShort;
            this.payloads.collectBoolean_target = AbstractImmutableSortedBagTestCase::collectBoolean_target;
            this.payloads.collectByte_target = AbstractImmutableSortedBagTestCase::collectByte_target;
            this.payloads.collectChar_target = AbstractImmutableSortedBagTestCase::collectChar_target;
            this.payloads.collectDouble_target = AbstractImmutableSortedBagTestCase::collectDouble_target;
            this.payloads.collectFloat_target = AbstractImmutableSortedBagTestCase::collectFloat_target;
            this.payloads.collectInt_target = AbstractImmutableSortedBagTestCase::collectInt_target;
            this.payloads.collectLong_target = AbstractImmutableSortedBagTestCase::collectLong_target;
            this.payloads.collectShort_target = AbstractImmutableSortedBagTestCase::collectShort_target;
            this.payloads.occurrencesOf = AbstractImmutableSortedBagTestCase::occurrencesOf;
            this.payloads.toImmutable = AbstractImmutableSortedBagTestCase::toImmutable;
            this.payloads.forEachFromTo = AbstractImmutableSortedBagTestCase::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = AbstractImmutableSortedBagTestCase::forEachWithIndexWithFromTo;
            this.payloads.topOccurrences = AbstractImmutableSortedBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractImmutableSortedBagTestCase::bottomOccurrences;
            this.payloads.corresponds = AbstractImmutableSortedBagTestCase::corresponds;
            this.payloads.detectIndex = AbstractImmutableSortedBagTestCase::detectIndex;
            this.payloads.indexOf = AbstractImmutableSortedBagTestCase::indexOf;
            this.payloads.take = AbstractImmutableSortedBagTestCase::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = AbstractImmutableSortedBagTestCase::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractImmutableSortedBagTestCase::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.selectUnique = AbstractImmutableSortedBagTestCase::selectUnique;
            this.payloads.distinctView = AbstractImmutableSortedBagTestCase::distinctView;
        }
    }
}
