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

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBagIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.MutableBagIterable;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.collection.mutable.AbstractCollectionTestCase;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Iterables;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public abstract class MutableBagTestCase extends AbstractCollectionTestCase {

    @Override
    protected abstract <T> MutableBagIterable<T> newWith(T... littleElements);

    protected abstract <T> MutableBagIterable<T> newWithOccurrences(ObjectIntPair<T>... elementsWithOccurrences);

    @Test
    @Override
    public void equalsAndHashCode() {
        super.equalsAndHashCode();
        Assert.assertNotEquals(this.newWith(1, 1, 2, 3), this.newWith(1, 2, 2, 3));
        Verify.assertEqualsAndHashCode(this.newWith(null, null, 2, 3), this.newWith(null, 2, null, 3));
        Assert.assertEquals(this.newWith(1, 1, 2, 3).toMapOfItemToCount().hashCode(), this.newWith(1, 1, 2, 3).hashCode());
        Assert.assertEquals(this.newWith(null, null, 2, 3).toMapOfItemToCount().hashCode(), this.newWith(null, null, 2, 3).hashCode());
    }

    @Test
    public void toStringOfItemToCount() {
        Assert.assertEquals("{}", this.newWith().toStringOfItemToCount());
        Assert.assertEquals("{1=3}", this.newWith(1, 1, 1).toStringOfItemToCount());
        String actual = this.newWith(1, 2, 2).toStringOfItemToCount();
        Assert.assertTrue("{1=1, 2=2}".equals(actual) || "{2=2, 1=1}".equals(actual));
    }

    @Test
    public void toMapOfItemToCount() {
        MutableBagIterable<Integer> bag = this.newWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), bag.toMapOfItemToCount());
    }

    @Test
    public void add() {
        MutableBagIterable<Integer> bag = this.newWith();
        bag.add(1);
        bag.add(1);
        Verify.assertSize(2, bag);
        bag.add(1);
        Verify.assertSize(3, bag);
    }

    @Override
    @Test
    public void iterator() {
        MutableBagIterable<Integer> bag = this.newWith(1, 1, 2);
        MutableList<Integer> validate = Lists.mutable.of();
        for (Integer each : bag) {
            validate.add(each);
        }
        Assert.assertEquals(HashBag.newBagWith(1, 1, 2), HashBag.newBag(validate));
        Iterator<Integer> iterator = bag.iterator();
        MutableBagIterable<Integer> expected = this.newWith(1, 1, 2);
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
        this.assertIteratorRemove(bag, iterator, expected);
        this.assertIteratorRemove(bag, iterator, expected);
        this.assertIteratorRemove(bag, iterator, expected);
        Verify.assertEmpty(bag);
        Assert.assertFalse(iterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, iterator::next);
    }

    private void assertIteratorRemove(MutableBagIterable<Integer> bag, Iterator<Integer> iterator, MutableBagIterable<Integer> expected) {
        Assert.assertTrue(iterator.hasNext());
        Integer first = iterator.next();
        iterator.remove();
        expected.remove(first);
        Assert.assertEquals(expected, bag);
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Test
    public void iteratorRemove() {
        MutableBagIterable<Integer> bag = this.newWith(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4);
        Iterator<Integer> iterator = bag.iterator();
        iterator.next();
        iterator.next();
        Integer value = iterator.next();
        Integer value2 = iterator.next();
        Assert.assertNotEquals(value, value2);
        iterator.remove();
        Integer value3 = iterator.next();
        Assert.assertNotEquals(value, value3);
        iterator.remove();
        Integer value4 = iterator.next();
        Assert.assertNotEquals(value, value4);
        iterator.remove();
        Integer value5 = iterator.next();
        Assert.assertNotEquals(value, value5);
    }

    @Test
    public void iteratorRemove2() {
        MutableBagIterable<Integer> bag = this.newWith(1, 1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4);
        Iterator<Integer> iterator = bag.iterator();
        iterator.next();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.remove();
        iterator.next();
        iterator.next();
        iterator.remove();
        Assert.assertEquals(4, bag.sizeDistinct());
        Assert.assertEquals(8, bag.size());
    }

    @Override
    @Test
    public void removeIf() {
        super.removeIf();
        MutableBagIterable<Integer> objects = this.newWith(4, 1, 3, 3, 2);
        Assert.assertTrue(objects.removeIf(Predicates.equal(2)));
        Assert.assertEquals(HashBag.newBagWith(1, 3, 3, 4), objects);
        Assert.assertTrue(objects.removeIf(Predicates.equal(3)));
        Assert.assertEquals(HashBag.newBagWith(1, 4), objects);
    }

    @Override
    @Test
    public void forEach() {
        MutableBagIterable<Integer> bag = this.newWith(1, 1, 2);
        MutableList<Integer> validate = Lists.mutable.of();
        bag.forEach(CollectionAddProcedure.on(validate));
        Assert.assertEquals(HashBag.newBagWith(1, 1, 2), HashBag.newBag(validate));
    }

    @Test
    public void forEachWithOccurrences() {
        MutableBagIterable<Integer> bag = this.newWith();
        bag.addOccurrences(1, 3);
        bag.addOccurrences(2, 2);
        bag.addOccurrences(3, 1);
        IntegerSum sum = new IntegerSum(0);
        bag.forEachWithOccurrences((each, index) -> sum.add(each * index));
        Assert.assertEquals(10, sum.getIntSum());
        bag.removeOccurrences(2, 1);
        IntegerSum sum2 = new IntegerSum(0);
        bag.forEachWithOccurrences((each, index) -> sum2.add(each * index));
        Assert.assertEquals(8, sum2.getIntSum());
        bag.removeOccurrences(1, 3);
        IntegerSum sum3 = new IntegerSum(0);
        bag.forEachWithOccurrences((each, index) -> sum3.add(each * index));
        Assert.assertEquals(5, sum3.getIntSum());
    }

    @Test
    public void collectWithOccurrences() {
        Bag<Integer> bag1 = this.newWith(3, 3, 3, 2, 2, 1);
        Bag<ObjectIntPair<Integer>> actual1 = bag1.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Bag<ObjectIntPair<Integer>> expected1 = Bags.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1));
        Assert.assertEquals(expected1, actual1);
        Assert.assertEquals(expected1, bag1.collectWithOccurrences(PrimitiveTuples::pair));
        Set<ObjectIntPair<Integer>> actual2 = bag1.collectWithOccurrences(PrimitiveTuples::pair, Sets.mutable.empty());
        ImmutableSet<ObjectIntPair<Integer>> expected2 = Sets.immutable.with(PrimitiveTuples.pair(Integer.valueOf(3), 3), PrimitiveTuples.pair(Integer.valueOf(2), 2), PrimitiveTuples.pair(Integer.valueOf(1), 1));
        Assert.assertEquals(expected2, actual2);
        Bag<Integer> bag2 = this.newWith(3, 3, 3, 3, 3, 2, 2, 2, 1, 1, 1, 1, 1, 4, 5, 7);
        Assert.assertEquals(this.newWith(8, 5, 6, 5, 6, 8), bag2.collectWithOccurrences((each, index) -> each + index));
    }

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        Verify.assertInstanceOf(MutableBagIterable.class, this.newWith());
        Verify.assertInstanceOf(ImmutableBagIterable.class, this.newWith().toImmutable());
        Assert.assertFalse(this.newWith().toImmutable() instanceof MutableBagIterable);
    }

    @Test
    @Override
    public void getLast() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1).getLast());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(3).getLast());
    }

    @Test
    public void occurrencesOf() {
        MutableBagIterable<Integer> bag = this.newWith(1, 1, 2);
        Assert.assertEquals(2, bag.occurrencesOf(1));
        Assert.assertEquals(1, bag.occurrencesOf(2));
    }

    @Test
    public void addOccurrences() {
        MutableBagIterable<String> bag = this.newWith();
        Assert.assertEquals(0, bag.addOccurrences("0", 0));
        Assert.assertEquals(1, bag.addOccurrences("1", 1));
        Assert.assertEquals(1, bag.addOccurrences("1", 0));
        Assert.assertEquals(2, bag.addOccurrences("2", 2));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith("1", "2", "2"), bag);
        Assert.assertEquals(1, bag.addOccurrences("1", 0));
        Assert.assertEquals(6, bag.addOccurrences("2", 4));
        Assert.assertEquals(1, bag.addOccurrences("3", 1));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith("1", "2", "2", "2", "2", "2", "2", "3"), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences(new Object(), -1);
    }

    @Test
    public void removeOccurrences() {
        MutableBagIterable<String> bag = this.newWith("betamax-tape", "betamax-tape");
        MutableBagIterable<String> expected = HashBag.newBag(bag);
        Assert.assertFalse(bag.removeOccurrences("dvd", 2));
        MutableBagTestCase.assertBagsEqual(expected, bag);
        Assert.assertFalse(bag.removeOccurrences("dvd", 0));
        MutableBagTestCase.assertBagsEqual(expected, bag);
        Assert.assertFalse(bag.removeOccurrences("betamax-tape", 0));
        MutableBagTestCase.assertBagsEqual(expected, bag);
        Assert.assertTrue(bag.removeOccurrences("betamax-tape", 1));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith("betamax-tape"), bag);
        Assert.assertTrue(bag.removeOccurrences("betamax-tape", 10));
        MutableBagTestCase.assertBagsEqual(HashBag.<String>newBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void removeOccurrences_throws() {
        this.newWith().removeOccurrences(new Object(), -1);
    }

    @Test
    public void setOccurrences() {
        MutableBagIterable<String> bag = this.newWith();
        MutableBagIterable<String> expected = this.newWith("betamax-tape", "betamax-tape");
        Assert.assertTrue(bag.setOccurrences("betamax-tape", 2));
        MutableBagTestCase.assertBagsEqual(expected, bag);
        Assert.assertFalse(bag.setOccurrences("betamax-tape", 2));
        MutableBagTestCase.assertBagsEqual(expected, bag);
        Assert.assertFalse(bag.setOccurrences("dvd", 0));
        MutableBagTestCase.assertBagsEqual(expected, bag);
        Assert.assertTrue(bag.setOccurrences("betamax-tape", 3));
        MutableBagTestCase.assertBagsEqual(expected.with("betamax-tape"), bag);
        Assert.assertTrue(bag.setOccurrences("betamax-tape", 0));
        MutableBagTestCase.assertBagsEqual(HashBag.<String>newBag(), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void setOccurrences_throws() {
        this.newWith().setOccurrences(new Object(), -1);
    }

    protected static void assertBagsEqual(Bag<?> expected, Bag<?> actual) {
        Assert.assertEquals(expected.toMapOfItemToCount(), actual.toMapOfItemToCount());
        Assert.assertEquals(expected.sizeDistinct(), actual.sizeDistinct());
        Assert.assertEquals(expected.size(), actual.size());
        Verify.assertEqualsAndHashCode(expected, actual);
    }

    @Test
    public void toSortedListWith() {
        Assert.assertEquals(FastList.newListWith(1, 2, 2, 3, 3, 3), this.newWith(3, 3, 3, 2, 2, 1).toSortedList());
    }

    @Override
    @Test
    public void toSet() {
        super.toSet();
        MutableBagIterable<Integer> bag = this.newWith(3, 3, 3, 2, 2, 1);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), bag.toSet());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableBagIterable<Integer> bag = this.newWith(1, 1, 1);
        Assert.assertEquals(FastList.newListWith(1, 1, 1), bag.toList());
    }

    @Override
    @Test
    public void removeObject() {
        super.removeObject();
        MutableBagIterable<String> bag = this.newWith("dakimakura", "dakimakura");
        Assert.assertFalse(bag.remove("Mr. T"));
        Assert.assertTrue(bag.remove("dakimakura"));
        Assert.assertTrue(bag.remove("dakimakura"));
        Assert.assertFalse(bag.remove("dakimakura"));
        MutableBagTestCase.assertBagsEqual(Bags.mutable.of(), bag);
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

    @Test
    public void serialization() {
        MutableBagIterable<String> bag = this.newWith("One", "Two", "Two", "Three", "Three", "Three");
        Verify.assertPostSerializedEqualsAndHashCode(bag);
    }

    @Override
    @Test
    public void partition() {
        super.partition();
        MutableBagIterable<Integer> integers = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        PartitionMutableCollection<Integer> result = integers.partition(IntegerPredicates.isEven());
        Assert.assertEquals(Iterables.iBag(2, 2, 4, 4, 4, 4), result.getSelected());
        Assert.assertEquals(Iterables.iBag(1, 3, 3, 3), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        super.partitionWith();
        MutableBagIterable<Integer> integers = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        PartitionMutableCollection<Integer> result = integers.partitionWith(Predicates2.in(), integers.select(IntegerPredicates.isEven()));
        Assert.assertEquals(Iterables.iBag(2, 2, 4, 4, 4, 4), result.getSelected());
        Assert.assertEquals(Iterables.iBag(1, 3, 3, 3), result.getRejected());
    }

    @Test
    public void selectByOccurrences() {
        MutableBagIterable<Integer> integers = this.newWith(1, 1, 1, 1, 2, 2, 2, 3, 3, 4);
        Assert.assertEquals(Iterables.iBag(1, 1, 1, 1, 3, 3), integers.selectByOccurrences(IntPredicates.isEven()));
    }

    @Test
    public void selectDuplicates() {
        MutableBagIterable<Integer> integers = this.newWith(0, 1, 1, 1, 1, 2, 2, 2, 3, 3, 4, 5);
        Assert.assertEquals(Iterables.iBag(1, 1, 1, 1, 2, 2, 2, 3, 3), integers.selectDuplicates());
    }

    @Test
    public void topOccurrences() {
        MutableBagIterable<String> strings = Bags.mutable.withOccurrences(PrimitiveTuples.pair("one", 1), PrimitiveTuples.pair("two", 2), PrimitiveTuples.pair("three", 3), PrimitiveTuples.pair("four", 4), PrimitiveTuples.pair("five", 5), PrimitiveTuples.pair("six", 6), PrimitiveTuples.pair("seven", 7), PrimitiveTuples.pair("eight", 8), PrimitiveTuples.pair("nine", 9), PrimitiveTuples.pair("ten", 10));
        MutableList<ObjectIntPair<String>> top5 = strings.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals("ten", top5.getFirst().getOne());
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals("six", top5.getLast().getOne());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith("one").topOccurrences(0));
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(2));
        Verify.assertSize(3, this.newWith("one", "one", "two", "three").topOccurrences(2));
        Verify.assertSize(2, this.newWith("one", "one", "two", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith(null, "one", "two").topOccurrences(5));
        Verify.assertSize(3, this.newWith(null, "one", "two").topOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "one", "two", "two", "three", "three").topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Verify.assertSize(0, this.newWith("one").topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Test
    public void anySatisfyWithOccurrences() {
        Bag<Integer> bag = this.newWith(3, 3, 3, 2, 2, 1);
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals(3) && value == 3));
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals(2) && value == 2));
        Assert.assertTrue(bag.anySatisfyWithOccurrences((object, value) -> object.equals(3)));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals(2) && value == 5));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals(1) && value == 7));
        Assert.assertFalse(bag.anySatisfyWithOccurrences((object, value) -> object.equals(10)));
    }

    @Test
    public void noneSatisfyWithOccurrences() {
        Bag<Integer> bag = this.newWith(3, 3, 3, 2, 2, 1);
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(3) && value == 1));
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(30)));
        Assert.assertFalse(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(3) && value == 3));
        Assert.assertTrue(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(1) && value == 0));
        Assert.assertFalse(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(1) && value == 1));
        Assert.assertFalse(bag.noneSatisfyWithOccurrences((object, value) -> object.equals(2)));
    }

    @Test
    public void allSatisfyWithOccurrences() {
        Bag<Integer> bag = this.newWith(3, 3, 3);
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> object.equals(3) && value == 3));
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> object.equals(3)));
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals(4) && value == 3));
        bag = this.newWith(3, 3, 3, 1);
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals(3) && value == 3));
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals(1) && value == 3));
        Assert.assertTrue(bag.allSatisfyWithOccurrences((object, value) -> object.equals(3) || object == 1));
        Assert.assertFalse(bag.allSatisfyWithOccurrences((object, value) -> object.equals(300) || object == 1));
    }

    @Test
    public void detectWithOccurrences() {
        Bag<Integer> bag = this.newWith(3, 3, 3, 2, 2, 1);
        Assert.assertEquals((Integer) 3, bag.detectWithOccurrences((object, value) -> object.equals(3) && value == 3));
        Assert.assertEquals((Integer) 3, bag.detectWithOccurrences((object, value) -> object.equals(3)));
        Assert.assertEquals((Integer) 1, bag.detectWithOccurrences((object, value) -> object.equals(1) && value == 1));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals(1) && value == 10));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals(10) && value == 5));
        Assert.assertNull(bag.detectWithOccurrences((object, value) -> object.equals(100)));
    }

    @Test
    public void bottomOccurrences() {
        MutableBagIterable<String> strings = Bags.mutable.ofOccurrences(PrimitiveTuples.pair("one", 1), PrimitiveTuples.pair("two", 2), PrimitiveTuples.pair("three", 3), PrimitiveTuples.pair("four", 4), PrimitiveTuples.pair("five", 5), PrimitiveTuples.pair("six", 6), PrimitiveTuples.pair("seven", 7), PrimitiveTuples.pair("eight", 8), PrimitiveTuples.pair("nine", 9), PrimitiveTuples.pair("ten", 10));
        MutableList<ObjectIntPair<String>> bottom5 = strings.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals("one", bottom5.getFirst().getOne());
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals("five", bottom5.getLast().getOne());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith("one").bottomOccurrences(0));
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").bottomOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").bottomOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "two", "three").bottomOccurrences(2));
        Verify.assertSize(2, this.newWith("one", "one", "two", "three").bottomOccurrences(2));
        Verify.assertSize(3, this.newWith("one", "one", "two", "two", "three").bottomOccurrences(2));
        Verify.assertSize(3, this.newWith(null, "one", "two").bottomOccurrences(5));
        Verify.assertSize(3, this.newWith(null, "one", "two").bottomOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "one", "two", "two", "three", "three").bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Verify.assertSize(0, this.newWith("one").bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Test
    public void selectUnique() {
        MutableBag<String> bag = Bags.mutable.with("0", "1", "1", "1", "1", "2", "2", "2", "3", "3", "4", "5");
        MutableSet<String> expected = Sets.mutable.with("0", "4", "5");
        MutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Override
    @Test
    public void zip() {
        super.zip();
        RichIterable<String> bag = this.newWith("1", "2", "3");
        Bag<Pair<String, String>> expected = this.newWith(Tuples.pair("1", "1"), Tuples.pair("2", "2"), Tuples.pair("3", "3"));
        Assert.assertEquals(expected, bag.zip(bag::iterator).toBag());
    }

    @Test
    public void distinctView() {
        MutableBagIterable<String> bag = this.newWith("1", "2", "2", "3", "3", "3", "3", "4", "5", "5", "6");
        RichIterable<String> expected = bag.toSet();
        RichIterable<String> actual = bag.distinctView();
        Assert.assertEquals(expected, actual);
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private MutableBagTestCase instance;

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
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getFirst);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
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
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
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
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
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
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove2);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
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
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
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
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new MutableBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> iteratorRemove2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> setOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSortedListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MutableBagTestCase> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = MutableBagTestCase::testNewCollection;
            this.payloads.contains = MutableBagTestCase::contains;
            this.payloads.containsBy = MutableBagTestCase::containsBy;
            this.payloads.containsAllIterable = MutableBagTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = MutableBagTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = MutableBagTestCase::containsNoneIterable;
            this.payloads.containsAllArray = MutableBagTestCase::containsAllArray;
            this.payloads.containsAnyCollection = MutableBagTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = MutableBagTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = MutableBagTestCase::containsAllCollection;
            this.payloads.tap = MutableBagTestCase::tap;
            this.payloads.forEachWith = MutableBagTestCase::forEachWith;
            this.payloads.forEachWithIndex = MutableBagTestCase::forEachWithIndex;
            this.payloads.select = MutableBagTestCase::select;
            this.payloads.selectWith = MutableBagTestCase::selectWith;
            this.payloads.selectWith_target = MutableBagTestCase::selectWith_target;
            this.payloads.reject = MutableBagTestCase::reject;
            this.payloads.rejectWith = MutableBagTestCase::rejectWith;
            this.payloads.rejectWith_target = MutableBagTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = MutableBagTestCase::selectInstancesOf;
            this.payloads.collect = MutableBagTestCase::collect;
            this.payloads.collectTarget = MutableBagTestCase::collectTarget;
            this.payloads.collectBoolean = MutableBagTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = MutableBagTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = MutableBagTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByte = MutableBagTestCase::collectByte;
            this.payloads.collectByteWithTarget = MutableBagTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = MutableBagTestCase::collectByteWithBagTarget;
            this.payloads.collectChar = MutableBagTestCase::collectChar;
            this.payloads.collectCharWithTarget = MutableBagTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = MutableBagTestCase::collectCharWithBagTarget;
            this.payloads.collectDouble = MutableBagTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = MutableBagTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = MutableBagTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloat = MutableBagTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = MutableBagTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = MutableBagTestCase::collectFloatWithBagTarget;
            this.payloads.collectInt = MutableBagTestCase::collectInt;
            this.payloads.collectIntWithTarget = MutableBagTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = MutableBagTestCase::collectIntWithBagTarget;
            this.payloads.collectLong = MutableBagTestCase::collectLong;
            this.payloads.collectLongWithTarget = MutableBagTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = MutableBagTestCase::collectLongWithBagTarget;
            this.payloads.collectShort = MutableBagTestCase::collectShort;
            this.payloads.collectShortWithTarget = MutableBagTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = MutableBagTestCase::collectShortWithBagTarget;
            this.payloads.flatCollect = MutableBagTestCase::flatCollect;
            this.payloads.flatCollectWith = MutableBagTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = MutableBagTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = MutableBagTestCase::flatCollectByte;
            this.payloads.flatCollectShort = MutableBagTestCase::flatCollectShort;
            this.payloads.flatCollectInt = MutableBagTestCase::flatCollectInt;
            this.payloads.flatCollectChar = MutableBagTestCase::flatCollectChar;
            this.payloads.flatCollectLong = MutableBagTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = MutableBagTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = MutableBagTestCase::flatCollectFloat;
            this.payloads.detect = MutableBagTestCase::detect;
            this.payloads.detectOptional = MutableBagTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = MutableBagTestCase::min;
            this.payloads.minOptional = MutableBagTestCase::minOptional;
            this.payloads.max = MutableBagTestCase::max;
            this.payloads.maxOptional = MutableBagTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = MutableBagTestCase::min_without_comparator;
            this.payloads.max_without_comparator = MutableBagTestCase::max_without_comparator;
            this.payloads.min_null_safe = MutableBagTestCase::min_null_safe;
            this.payloads.max_null_safe = MutableBagTestCase::max_null_safe;
            this.payloads.minBy = MutableBagTestCase::minBy;
            this.payloads.minByOptional = MutableBagTestCase::minByOptional;
            this.payloads.maxBy = MutableBagTestCase::maxBy;
            this.payloads.maxByOptional = MutableBagTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = MutableBagTestCase::detectWith;
            this.payloads.detectWithOptional = MutableBagTestCase::detectWithOptional;
            this.payloads.detectIfNone = MutableBagTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = MutableBagTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = MutableBagTestCase::allSatisfy;
            this.payloads.allSatisfyWith = MutableBagTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = MutableBagTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = MutableBagTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = MutableBagTestCase::anySatisfy;
            this.payloads.anySatisfyWith = MutableBagTestCase::anySatisfyWith;
            this.payloads.count = MutableBagTestCase::count;
            this.payloads.countWith = MutableBagTestCase::countWith;
            this.payloads.collectIf = MutableBagTestCase::collectIf;
            this.payloads.collectWith = MutableBagTestCase::collectWith;
            this.payloads.collectWith_target = MutableBagTestCase::collectWith_target;
            this.payloads.getAny = MutableBagTestCase::getAny;
            this.payloads.getFirst = MutableBagTestCase::getFirst;
            this.payloads.getOnly = MutableBagTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = MutableBagTestCase::isEmpty;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = MutableBagTestCase::injectInto;
            this.payloads.injectIntoInt = MutableBagTestCase::injectIntoInt;
            this.payloads.injectIntoLong = MutableBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = MutableBagTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = MutableBagTestCase::injectIntoFloat;
            this.payloads.sumFloat = MutableBagTestCase::sumFloat;
            this.payloads.summarizeFloat = MutableBagTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = MutableBagTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = MutableBagTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = MutableBagTestCase::sumDouble;
            this.payloads.summarizeDouble = MutableBagTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = MutableBagTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = MutableBagTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = MutableBagTestCase::sumInteger;
            this.payloads.summarizeInt = MutableBagTestCase::summarizeInt;
            this.payloads.sumLong = MutableBagTestCase::sumLong;
            this.payloads.summarizeLong = MutableBagTestCase::summarizeLong;
            this.payloads.sumByInt = MutableBagTestCase::sumByInt;
            this.payloads.sumByFloat = MutableBagTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = MutableBagTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = MutableBagTestCase::sumByLong;
            this.payloads.sumByDouble = MutableBagTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = MutableBagTestCase::sumByDoubleConsistentRounding;
            this.payloads.toArray = MutableBagTestCase::toArray;
            this.payloads.toImmutableList = MutableBagTestCase::toImmutableList;
            this.payloads.toCollection = MutableBagTestCase::toCollection;
            this.payloads.toBag = MutableBagTestCase::toBag;
            this.payloads.toImmutableBag = MutableBagTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = MutableBagTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = MutableBagTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = MutableBagTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = MutableBagTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = MutableBagTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = MutableBagTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = MutableBagTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = MutableBagTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = MutableBagTestCase::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = MutableBagTestCase::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = MutableBagTestCase::toSortedListBy;
            this.payloads.toImmutableSortedListBy = MutableBagTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = MutableBagTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = MutableBagTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = MutableBagTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = MutableBagTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = MutableBagTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = MutableBagTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = MutableBagTestCase::toImmutableSet;
            this.payloads.toMap = MutableBagTestCase::toMap;
            this.payloads.toImmutableMap = MutableBagTestCase::toImmutableMap;
            this.payloads.toMapTarget = MutableBagTestCase::toMapTarget;
            this.payloads.toSortedMap = MutableBagTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = MutableBagTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = MutableBagTestCase::toSortedMapBy;
            this.payloads.toBiMap = MutableBagTestCase::toBiMap;
            this.payloads.toImmutableBiMap = MutableBagTestCase::toImmutableBiMap;
            this.payloads.testToString = MutableBagTestCase::testToString;
            this.payloads.makeString = MutableBagTestCase::makeString;
            this.payloads.makeStringWithSeparator = MutableBagTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = MutableBagTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = MutableBagTestCase::fusedCollectMakeString;
            this.payloads.appendString = MutableBagTestCase::appendString;
            this.payloads.appendStringWithSeparator = MutableBagTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = MutableBagTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = MutableBagTestCase::appendStringThrows;
            this.payloads.countBy = MutableBagTestCase::countBy;
            this.payloads.countByWith = MutableBagTestCase::countByWith;
            this.payloads.countByEach = MutableBagTestCase::countByEach;
            this.payloads.groupBy = MutableBagTestCase::groupBy;
            this.payloads.groupByEach = MutableBagTestCase::groupByEach;
            this.payloads.groupByUniqueKey = MutableBagTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MutableBagTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zipWithIndex = MutableBagTestCase::zipWithIndex;
            this.payloads.chunk = MutableBagTestCase::chunk;
            this.payloads.chunk_empty = MutableBagTestCase::chunk_empty;
            this.payloads.chunk_single = MutableBagTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = MutableBagTestCase::chunk_large_size;
            this.payloads.empty = MutableBagTestCase::empty;
            this.payloads.notEmpty = MutableBagTestCase::notEmpty;
            this.payloads.aggregateByMutating = MutableBagTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MutableBagTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = MutableBagTestCase::reduceOptional;
            this.payloads.newEmpty = MutableBagTestCase::newEmpty;
            this.payloads.testNewWith = MutableBagTestCase::testNewWith;
            this.payloads.testNewWithWith = MutableBagTestCase::testNewWithWith;
            this.payloads.testNewWithWithWith = MutableBagTestCase::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = MutableBagTestCase::testNewWithVarArgs;
            this.payloads.addAll = MutableBagTestCase::addAll;
            this.payloads.addAllIterable = MutableBagTestCase::addAllIterable;
            this.payloads.removeAll = MutableBagTestCase::removeAll;
            this.payloads.removeAllIterable = MutableBagTestCase::removeAllIterable;
            this.payloads.retainAll = MutableBagTestCase::retainAll;
            this.payloads.retainAllIterable = MutableBagTestCase::retainAllIterable;
            this.payloads.clear = MutableBagTestCase::clear;
            this.payloads.injectIntoWith = MutableBagTestCase::injectIntoWith;
            this.payloads.selectAndRejectWith = MutableBagTestCase::selectAndRejectWith;
            this.payloads.removeIfWith = MutableBagTestCase::removeIfWith;
            this.payloads.with = MutableBagTestCase::with;
            this.payloads.withAll = MutableBagTestCase::withAll;
            this.payloads.without = MutableBagTestCase::without;
            this.payloads.withoutAll = MutableBagTestCase::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = MutableBagTestCase::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = MutableBagTestCase::asLazy;
            this.payloads.equalsAndHashCode = MutableBagTestCase::equalsAndHashCode;
            this.payloads.toStringOfItemToCount = MutableBagTestCase::toStringOfItemToCount;
            this.payloads.toMapOfItemToCount = MutableBagTestCase::toMapOfItemToCount;
            this.payloads.add = MutableBagTestCase::add;
            this.payloads.iterator = MutableBagTestCase::iterator;
            this.payloads.iteratorRemove = MutableBagTestCase::iteratorRemove;
            this.payloads.iteratorRemove2 = MutableBagTestCase::iteratorRemove2;
            this.payloads.removeIf = MutableBagTestCase::removeIf;
            this.payloads.forEach = MutableBagTestCase::forEach;
            this.payloads.forEachWithOccurrences = MutableBagTestCase::forEachWithOccurrences;
            this.payloads.collectWithOccurrences = MutableBagTestCase::collectWithOccurrences;
            this.payloads.toImmutable = MutableBagTestCase::toImmutable;
            this.payloads.getLast = MutableBagTestCase::getLast;
            this.payloads.occurrencesOf = MutableBagTestCase::occurrencesOf;
            this.payloads.addOccurrences = MutableBagTestCase::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = MutableBagTestCase::removeOccurrences;
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.setOccurrences = MutableBagTestCase::setOccurrences;
            this.payloads.setOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MutableBagTestCase::setOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.toSortedListWith = MutableBagTestCase::toSortedListWith;
            this.payloads.toSet = MutableBagTestCase::toSet;
            this.payloads.toList = MutableBagTestCase::toList;
            this.payloads.removeObject = MutableBagTestCase::removeObject;
            this.payloads.asSynchronized = MutableBagTestCase::asSynchronized;
            this.payloads.asUnmodifiable = MutableBagTestCase::asUnmodifiable;
            this.payloads.serialization = MutableBagTestCase::serialization;
            this.payloads.partition = MutableBagTestCase::partition;
            this.payloads.partitionWith = MutableBagTestCase::partitionWith;
            this.payloads.selectByOccurrences = MutableBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = MutableBagTestCase::selectDuplicates;
            this.payloads.topOccurrences = MutableBagTestCase::topOccurrences;
            this.payloads.anySatisfyWithOccurrences = MutableBagTestCase::anySatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = MutableBagTestCase::noneSatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = MutableBagTestCase::allSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = MutableBagTestCase::detectWithOccurrences;
            this.payloads.bottomOccurrences = MutableBagTestCase::bottomOccurrences;
            this.payloads.selectUnique = MutableBagTestCase::selectUnique;
            this.payloads.zip = MutableBagTestCase::zip;
            this.payloads.distinctView = MutableBagTestCase::distinctView;
        }
    }
}
