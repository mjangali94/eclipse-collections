/*
 * Copyright (c) 2021 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.mutable;

import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.partition.PartitionMutableCollection;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.parallel.ParallelIterate;
import org.eclipse.collections.impl.set.mutable.MultiReaderMutableCollectionTestCase;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.test.SerializeTestHelper;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * JUnit test for {@link MultiReaderHashBag}.
 */
public class MultiReaderHashBagTest extends MultiReaderMutableCollectionTestCase {

    @Override
    protected <T> MultiReaderHashBag<T> newWith(T... littleElements) {
        return MultiReaderHashBag.newBagWith(littleElements);
    }

    @Override
    @Test(expected = UnsupportedOperationException.class)
    public void largeCollectionStreamToBagMultimap() {
        super.largeCollectionStreamToBagMultimap();
    }

    @Override
    @Test
    public void newEmpty() {
        Verify.assertInstanceOf(MultiReaderHashBag.class, MultiReaderHashBag.newBag().newEmpty());
        Verify.assertEmpty(MultiReaderHashBag.<Integer>newBagWith(null, null).newEmpty());
    }

    @Test
    public void hashBagNewWith() {
        Assert.assertEquals(HashBag.newBagWith("Alice", "Bob", "Bob", "Bob", "Cooper", "Dio"), HashBag.newBagWith("Alice", "Bob", "Cooper", "Dio", "Bob", "Bob"));
    }

    @Override
    @Test
    public void asSynchronized() {
        Verify.assertInstanceOf(SynchronizedBag.class, MultiReaderHashBag.newBag().asSynchronized());
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableBag.class, this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void toImmutable() {
        Verify.assertInstanceOf(ImmutableBag.class, this.newWith().toImmutable());
    }

    @Test
    public void addOccurrences() {
        MultiReaderHashBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 2, 3);
        Assert.assertEquals(2, bag.addOccurrences(1, 0));
        Assert.assertEquals(4, bag.addOccurrences(1, 2));
        Assert.assertEquals(0, bag.addOccurrences(4, 0));
        Assert.assertEquals(2, bag.addOccurrences(4, 2));
        Assert.assertEquals(2, bag.addOccurrences(2, 1));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 1, 1, 2, 2, 3, 4, 4), bag);
        Assert.assertEquals(3, bag.addOccurrences(2, 1));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 1, 1, 2, 2, 2, 3, 4, 4), bag);
    }

    @Test(expected = IllegalArgumentException.class)
    public void addOccurrences_throws() {
        this.newWith().addOccurrences(new Object(), -1);
    }

    @Test
    public void removeOccurrences() {
        MultiReaderHashBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 1, 1, 2, 2, 3);
        Assert.assertFalse(bag.removeOccurrences(4, 2));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 1, 1, 2, 2, 3), bag);
        bag.removeOccurrences(1, 3);
        bag.removeOccurrences(3, 1);
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 2, 2), bag);
    }

    @Test
    public void setOccurrences() {
        MultiReaderHashBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 2);
        Assert.assertFalse(bag.setOccurrences(1, 2));
        Assert.assertTrue(bag.setOccurrences(3, 3));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 2, 3, 3, 3), bag);
        Assert.assertTrue(bag.setOccurrences(2, 0));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith(1, 1, 3, 3, 3), bag);
    }

    @Test
    public void occurrencesOf() {
        MultiReaderHashBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 2);
        Assert.assertEquals(2, bag.occurrencesOf(1));
        Assert.assertEquals(1, bag.occurrencesOf(2));
    }

    @Test
    public void sizeDistinct() {
        MultiReaderHashBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 2, 2, 3);
        Assert.assertEquals(3, bag.sizeDistinct());
    }

    @Override
    @Test
    public void collect() {
        MutableBag<Boolean> bag = MultiReaderHashBag.newBagWith(Boolean.TRUE, Boolean.FALSE, null);
        MutableBag<String> newCollection = bag.collect(String::valueOf);
        Assert.assertEquals(HashBag.newBagWith("true", "false", "null"), newCollection);
    }

    @Override
    @Test
    public void flatCollect() {
        MutableBag<Integer> collection = MultiReaderHashBag.newBagWith(1, 1, 2, 3, 4);
        Function<Integer, MutableBag<String>> function = object -> HashBag.newBagWith(String.valueOf(object));
        MutableBagTestCase.assertBagsEqual(HashBag.newBagWith("1", "1", "2", "3", "4"), collection.flatCollect(function));
    }

    @Override
    @Test
    public void collectIf() {
        Assert.assertEquals(HashBag.newBagWith("1", "1", "2", "3"), MultiReaderHashBag.newBagWith(1, 1, 2, 3).collectIf(Integer.class::isInstance, String::valueOf));
        Assert.assertEquals(HashBag.newBagWith("1", "1"), MultiReaderHashBag.newBagWith(1, 1, 2, 3).collectIf(Predicates.lessThan(2), String::valueOf));
    }

    @Override
    @Test
    public void collectWith() {
        Function2<Integer, Integer, Integer> addZeroFunction = (each, parameter) -> each + parameter;
        Verify.assertContainsAll(MultiReaderHashBag.newBagWith(1, 1, 2, 3).collectWith(addZeroFunction, 0), 1, 2, 3);
        Verify.assertContainsAll(MultiReaderHashBag.newBagWith(1, 1, 2, 3).collectWith(addZeroFunction, 0, HashBag.newBag()), 1, 2, 3);
    }

    @Override
    @Test
    public void reject() {
        Verify.assertContainsAll(MultiReaderHashBag.newBagWith(1, 1, 2, 3, 4).reject(Predicates.lessThan(3)), 3, 4);
        Verify.assertContainsAll(MultiReaderHashBag.newBagWith(1, 2, 3, 3, 4).reject(Predicates.lessThan(3), HashBag.newBag()), 3, 4);
    }

    @Override
    @Test
    public void rejectWith() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 2, 1);
        MutableBag<Integer> results = bag.rejectWith(Predicates2.instanceOf(), Integer.class);
        Verify.assertEmpty(results);
    }

    @Override
    @Test
    public void select() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 2, 2, 3, 4, 5, 5, 1);
        MutableBag<Integer> results = bag.select(Integer.valueOf(1)::equals);
        MutableBagTestCase.assertBagsEqual(results, MultiReaderHashBag.newBagWith(1, 1));
    }

    @Override
    @Test
    public void selectWith() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 2, 2);
        MutableBag<Integer> results = bag.selectWith(Predicates2.instanceOf(), Integer.class);
        Verify.assertSize(4, results);
    }

    @Test
    public void selectByOccurrences() {
        MultiReaderHashBag<Integer> numbers = MultiReaderHashBag.newBagWith(1, 1, 2, 2, 2, 3);
        MutableBag<Integer> results = numbers.selectByOccurrences(IntPredicates.isEven());
        Verify.assertSize(2, results);
        MutableBagTestCase.assertBagsEqual(results, MultiReaderHashBag.newBagWith(1, 1));
        numbers.withReadLockAndDelegate(bag -> {
            MutableBag<Integer> results2 = bag.selectByOccurrences(IntPredicates.isEven());
            Verify.assertSize(2, results2);
            MutableBagTestCase.assertBagsEqual(results2, MultiReaderHashBag.newBagWith(1, 1));
        });
    }

    @Test
    public void selectDuplicates() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(0, 1, 1, 2, 2, 2, 3);
        MutableBagTestCase.assertBagsEqual(MultiReaderHashBag.newBagWith(1, 1, 2, 2, 2), bag.selectDuplicates());
    }

    @Override
    @Test
    public void selectInstancesOf() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 2, 2, 2, 3);
        MutableBagTestCase.assertBagsEqual(bag.selectInstancesOf(Integer.class), MultiReaderHashBag.newBagWith(1, 1, 2, 2, 2, 3));
    }

    @Override
    @Test
    public void partition() {
        MutableBag<Integer> integers = MultiReaderHashBag.newBagWith(-3, -2, -1, 0, 1, 2, 2, 2, 3, 3, 4, 5);
        PartitionMutableCollection<Integer> result = integers.partition(IntegerPredicates.isEven());
        Assert.assertEquals(MultiReaderHashBag.newBagWith(-2, 0, 2, 2, 2, 4), result.getSelected());
        Assert.assertEquals(MultiReaderHashBag.newBagWith(-3, -1, 1, 3, 3, 5), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        MutableBag<Integer> integers = MultiReaderHashBag.newBagWith(-3, -2, -1, 0, 1, 2, 2, 2, 3, 3, 4, 5);
        PartitionMutableCollection<Integer> result = integers.partitionWith(Predicates2.in(), integers.select(IntegerPredicates.isEven()));
        Assert.assertEquals(MultiReaderHashBag.newBagWith(-2, 0, 2, 2, 2, 4), result.getSelected());
        Assert.assertEquals(MultiReaderHashBag.newBagWith(-3, -1, 1, 3, 3, 5), result.getRejected());
    }

    @Override
    @Test
    public void with() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 2, 3, 3);
        MutableBag<Integer> bagWith = bag.with(3);
        MutableBagTestCase.assertBagsEqual(MultiReaderHashBag.newBagWith(1, 2, 3, 3, 3), bagWith);
    }

    @Override
    @Test
    public void without() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 2, 3, 3);
        MutableBag<Integer> bagWithout = bag.without(3);
        MutableBagTestCase.assertBagsEqual(MultiReaderHashBag.newBagWith(1, 2, 3), bagWithout);
    }

    @Override
    @Test
    public void withAll() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 2, 3, 3);
        MutableBag<Integer> bagWith = bag.withAll(FastList.newListWith(2, 4, 4));
        MutableBagTestCase.assertBagsEqual(MultiReaderHashBag.newBagWith(1, 2, 2, 3, 3, 4, 4), bagWith);
    }

    @Override
    @Test
    public void withoutAll() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 2, 3, 3, 4);
        MutableBag<Integer> bagWithout = bag.withoutAll(FastList.newListWith(3, 4));
        MutableBagTestCase.assertBagsEqual(MultiReaderHashBag.newBagWith(1, 2), bagWithout);
    }

    @Test
    public void toMapOfItemToCount() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 2, 2, 3, 3, 3);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), bag.toMapOfItemToCount());
    }

    @Test
    public void toStringOfItemToCount() {
        Assert.assertEquals("{}", MultiReaderHashBag.newBagWith().toStringOfItemToCount());
        Assert.assertEquals("{1=3}", MultiReaderHashBag.newBagWith(1, 1, 1).toStringOfItemToCount());
        String actual = MultiReaderHashBag.newBagWith(1, 2, 2).toStringOfItemToCount();
        Assert.assertTrue("{1=1, 2=2}".equals(actual) || "{2=2, 1=1}".equals(actual));
    }

    @Test
    public void forEachWithOccurrences() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 2, 2, 3, 3, 3);
        int[] sum = new int[1];
        bag.forEachWithOccurrences((each, occurrences) -> {
            if (occurrences > 1) {
                sum[0] += each * occurrences;
            }
        });
        Assert.assertEquals(13, sum[0]);
    }

    @Test
    public void equalsAndHashCose() {
        MutableBag<Integer> integers = MultiReaderHashBag.newBagWith(1, 2, 3);
        MutableBag<Integer> integers2 = MultiReaderHashBag.newBagWith(1, 2, 3);
        MutableBag<Integer> integers3 = MultiReaderHashBag.newBagWith(1, null, 3, 4, 5);
        MutableBag<Integer> integers4 = MultiReaderHashBag.newBagWith(1, null, 3, 4, 5);
        MutableBag<Integer> integers5 = MultiReaderHashBag.newBagWith(1, null, 3);
        MutableBag<Integer> randomAccessList = Bags.mutable.of(1, 2, 3);
        MutableBag<Integer> randomAccessList2 = Bags.mutable.of(2, 3, 4);
        Verify.assertEqualsAndHashCode(integers, integers);
        Verify.assertPostSerializedEqualsAndHashCode(integers);
        Verify.assertEqualsAndHashCode(integers, integers2);
        Verify.assertEqualsAndHashCode(integers, randomAccessList);
        Assert.assertNotEquals(integers, integers3);
        Assert.assertNotEquals(integers, integers5);
        Assert.assertNotEquals(integers, randomAccessList2);
        Assert.assertNotEquals(integers, Sets.fixedSize.of());
        Verify.assertEqualsAndHashCode(integers3, integers4);
        Assert.assertEquals(integers, integers2);
        Assert.assertNotEquals(integers, integers3);
    }

    @Override
    @Test
    public void toSet() {
        super.toSet();
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(3, 3, 3, 2, 2, 1);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), bag.toSet());
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 1);
        Assert.assertEquals(FastList.newListWith(1, 1, 1), bag.toList());
    }

    @Override
    @Test
    public void injectInto() {
        MutableBag<Integer> bag = MultiReaderHashBag.newBagWith(1, 1, 3);
        Assert.assertEquals(Integer.valueOf(6), bag.injectInto(1, AddFunction.INTEGER));
    }

    @Override
    @Test
    public void forEach() {
        MutableBag<Integer> result = HashBag.newBag();
        MutableBag<Integer> collection = MultiReaderHashBag.newBagWith(1, 2, 3, 4, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Assert.assertEquals(HashBag.newBagWith(1, 2, 3, 4, 4), result);
    }

    @Override
    @Test
    public void isEmpty() {
        Verify.assertEmpty(MultiReaderHashBag.newBag());
        Verify.assertNotEmpty(MultiReaderHashBag.newBagWith(1, 1));
    }

    @Test
    public void serialization() {
        MutableBag<Integer> collection = MultiReaderHashBag.newBagWith(1, 1, 3, 4, 5);
        MutableBag<Integer> deserializedCollection = SerializeTestHelper.serializeDeserialize(collection);
        Verify.assertSize(5, deserializedCollection);
        Assert.assertEquals(collection, deserializedCollection);
    }

    private void verifyDelegateIsUnmodifiable(MutableBag<Integer> delegate) {
        Assert.assertThrows(UnsupportedOperationException.class, () -> delegate.add(2));
        Assert.assertThrows(UnsupportedOperationException.class, () -> delegate.remove(0));
    }

    @Test
    public void withReadLockAndDelegate() {
        MultiReaderHashBag<Integer> bag = MultiReaderHashBag.newBagWith(1);
        Object[] result = new Object[1];
        bag.withReadLockAndDelegate(delegate -> {
            result[0] = delegate.getFirst();
            this.verifyDelegateIsUnmodifiable(delegate);
        });
        Assert.assertNotNull(result[0]);
    }

    @Override
    @Test
    public void makeString() {
        Assert.assertEquals("[1, 1, 2, 3]", MultiReaderHashBag.newBagWith(1, 1, 2, 3).toString());
    }

    @Override
    @Test
    public void appendString() {
        Appendable builder = new StringBuilder();
        MultiReaderHashBag.newBagWith(1, 1, 2, 3).appendString(builder);
        Assert.assertEquals("1, 1, 2, 3", builder.toString());
    }

    @Override
    @Test
    public void testToString() {
        Assert.assertEquals("[1, 1, 2, 3]", MultiReaderHashBag.newBagWith(1, 1, 2, 3).toString());
    }

    @Override
    @Test
    public void iterator() {
        MultiReaderHashBag<Integer> integers = MultiReaderHashBag.newBagWith(1, 1, 2, 3, 4);
        Assert.assertThrows(UnsupportedOperationException.class, integers::iterator);
    }

    @Test(expected = UnsupportedOperationException.class)
    public void listIterator() {
        MultiReaderHashBag<Integer> integers = MultiReaderHashBag.newBagWith(1, 1, 2, 3, 4);
        integers.iterator();
    }

    @Test
    public void withWriteLockAndDelegate() {
        MultiReaderHashBag<Integer> bag = MultiReaderHashBag.newBagWith(2);
        AtomicReference<MutableBag<?>> delegateList = new AtomicReference<>();
        AtomicReference<Iterator<?>> iterator = new AtomicReference<>();
        bag.withWriteLockAndDelegate(delegate -> {
            delegate.add(1);
            delegate.add(2);
            delegate.add(3);
            delegate.add(4);
            delegateList.set(delegate);
            iterator.set(delegate.iterator());
        });
        Assert.assertEquals(HashBag.newBagWith(1, 2, 2, 3, 4), bag);
        Assert.assertThrows(NullPointerException.class, () -> iterator.get().hasNext());
        Assert.assertThrows(NullPointerException.class, () -> delegateList.get().iterator());
    }

    @Test
    public void concurrentWrite() {
        MultiReaderHashBag<Integer> numbers = this.newWith();
        Interval interval = Interval.oneTo(100);
        ParallelIterate.forEach(interval, each -> {
            numbers.add(each);
            Verify.assertSize(1, numbers.select(each::equals));
            numbers.add(each);
            Assert.assertEquals(2, numbers.count(each::equals));
            numbers.add(each);
            Integer[] removed = new Integer[1];
            numbers.withWriteLockAndDelegate(bag -> {
                Iterator<Integer> iterator = bag.iterator();
                removed[0] = iterator.next();
                bag.remove(removed[0]);
                bag.add(removed[0]);
            });
            numbers.add(each);
            Assert.assertEquals(4, numbers.count(each::equals));
        }, 1);
        interval.forEach(Procedures.cast(each -> Assert.assertEquals(4, numbers.occurrencesOf(each))));
    }

    @Test
    public void parallelCollect() {
        MultiReaderHashBag<String> numbers = this.newWith();
        Interval interval = Interval.oneTo(50000);
        ParallelIterate.collect(interval, String::valueOf, numbers, true);
        Assert.assertEquals(numbers, interval.collect(String::valueOf).toBag());
    }

    @Test
    public void selectUnique() {
        MutableBag<String> bag = this.newWith("0", "1", "1", "1", "1", "2", "2", "2", "3", "3", "4", "5");
        MutableSet<String> expected = Sets.mutable.with("0", "4", "5");
        MutableSet<String> actual = bag.selectUnique();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void topOccurrences() {
        MultiReaderHashBag<Integer> numbers = this.newWith(1, 1, 1, 2, 2, 3, 3);
        MutableList<ObjectIntPair<Integer>> pairs = numbers.topOccurrences(1);
        Assert.assertEquals(Integer.valueOf(1), pairs.getFirst().getOne());
        Assert.assertEquals(3, pairs.getFirst().getTwo());
        numbers.withReadLockAndDelegate(bag -> {
            Assert.assertEquals(Integer.valueOf(1), bag.topOccurrences(1).getFirst().getOne());
            Assert.assertEquals(3, bag.topOccurrences(1).getFirst().getTwo());
        });
    }

    @Test
    public void bottomOccurrences() {
        MultiReaderHashBag<Integer> numbers = this.newWith(1, 1, 1, 2, 2, 3, 3);
        MutableList<ObjectIntPair<Integer>> pairs = numbers.bottomOccurrences(1);
        Verify.assertSize(2, pairs);
        Verify.assertAnySatisfy(pairs, pair -> pair.getOne().equals(new Integer(2)));
        Verify.assertAnySatisfy(pairs, pair -> pair.getOne().equals(new Integer(3)));
        numbers.withReadLockAndDelegate(bag -> {
            Verify.assertSize(2, bag.bottomOccurrences(1));
            Verify.assertAnySatisfy(bag.bottomOccurrences(1), pair -> pair.getOne().equals(new Integer(2)));
            Verify.assertAnySatisfy(bag.bottomOccurrences(1), pair -> pair.getOne().equals(new Integer(3)));
        });
    }

    @Test
    public void collectWithOccurrences() {
        MultiReaderHashBag<Integer> numbers = this.newWith(1, 1, 1, 2, 2, 3, 3);
        MutableBag<ObjectIntPair<Integer>> pairs = numbers.collectWithOccurrences(PrimitiveTuples::pair);
        Verify.assertAnySatisfy(pairs, pair -> pair.getOne().equals(new Integer(1)) && pair.getTwo() == 3);
        Verify.assertAnySatisfy(pairs, pair -> pair.getOne().equals(new Integer(2)) && pair.getTwo() == 2);
        Verify.assertAnySatisfy(pairs, pair -> pair.getOne().equals(new Integer(3)) && pair.getTwo() == 2);
        numbers.withReadLockAndDelegate(bag -> {
            MutableBag<ObjectIntPair<Integer>> pairs2 = bag.collectWithOccurrences(PrimitiveTuples::pair);
            Verify.assertAnySatisfy(pairs2, pair -> pair.getOne().equals(new Integer(1)) && pair.getTwo() == 3);
            Verify.assertAnySatisfy(pairs2, pair -> pair.getOne().equals(new Integer(2)) && pair.getTwo() == 2);
            Verify.assertAnySatisfy(pairs2, pair -> pair.getOne().equals(new Integer(3)) && pair.getTwo() == 2);
        });
    }

    @Test
    public void collectWithOccurrencesWithTarget() {
        MultiReaderHashBag<Integer> numbers = this.newWith(1, 1, 1, 2, 2, 3, 3);
        MutableBag<ObjectIntPair<Integer>> pairs = numbers.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
        Verify.assertAnySatisfy(pairs, pair -> pair.getOne().equals(new Integer(1)) && pair.getTwo() == 3);
        Verify.assertAnySatisfy(pairs, pair -> pair.getOne().equals(new Integer(2)) && pair.getTwo() == 2);
        Verify.assertAnySatisfy(pairs, pair -> pair.getOne().equals(new Integer(3)) && pair.getTwo() == 2);
        numbers.withReadLockAndDelegate(bag -> {
            MutableBag<ObjectIntPair<Integer>> pairs2 = bag.collectWithOccurrences(PrimitiveTuples::pair, Bags.mutable.empty());
            Verify.assertAnySatisfy(pairs2, pair -> pair.getOne().equals(new Integer(1)) && pair.getTwo() == 3);
            Verify.assertAnySatisfy(pairs2, pair -> pair.getOne().equals(new Integer(2)) && pair.getTwo() == 2);
            Verify.assertAnySatisfy(pairs2, pair -> pair.getOne().equals(new Integer(3)) && pair.getTwo() == 2);
        });
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        public _Payloads payloads;

        public MultiReaderHashBagTest instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
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
        public void benchmark_getLast() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getLast);
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
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_spliterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.spliterator_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_stream_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.stream_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelStream_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelStream_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_hashBagNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.hashBagNewWith);
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
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
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
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sizeDistinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sizeDistinct);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
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
        public void benchmark_reject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reject);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.rejectWith);
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
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
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
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCose() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCose);
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
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEach);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withReadLockAndDelegate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withReadLockAndDelegate);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_listIterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.listIterator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withWriteLockAndDelegate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withWriteLockAndDelegate);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_concurrentWrite() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.concurrentWrite);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_parallelCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.parallelCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
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
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrencesWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrencesWithTarget);
        }

        public void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> payload) throws java.lang.Throwable {
            this.instance = new MultiReaderHashBagTest();
            payload.accept(this.instance);
        }

        public static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> spliterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> stream_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> parallelStream_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> hashBagNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> sizeDistinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> equalsAndHashCose;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> withReadLockAndDelegate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> listIterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> withWriteLockAndDelegate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> concurrentWrite;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> parallelCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<MultiReaderHashBagTest> collectWithOccurrencesWithTarget;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = MultiReaderHashBagTest::testNewCollection;
            this.payloads.equalsAndHashCode = MultiReaderHashBagTest::equalsAndHashCode;
            this.payloads.contains = MultiReaderHashBagTest::contains;
            this.payloads.containsBy = MultiReaderHashBagTest::containsBy;
            this.payloads.containsAllIterable = MultiReaderHashBagTest::containsAllIterable;
            this.payloads.containsAnyIterable = MultiReaderHashBagTest::containsAnyIterable;
            this.payloads.containsNoneIterable = MultiReaderHashBagTest::containsNoneIterable;
            this.payloads.containsAllArray = MultiReaderHashBagTest::containsAllArray;
            this.payloads.containsAnyCollection = MultiReaderHashBagTest::containsAnyCollection;
            this.payloads.containsNoneCollection = MultiReaderHashBagTest::containsNoneCollection;
            this.payloads.containsAllCollection = MultiReaderHashBagTest::containsAllCollection;
            this.payloads.tap = MultiReaderHashBagTest::tap;
            this.payloads.forEachWith = MultiReaderHashBagTest::forEachWith;
            this.payloads.forEachWithIndex = MultiReaderHashBagTest::forEachWithIndex;
            this.payloads.selectWith_target = MultiReaderHashBagTest::selectWith_target;
            this.payloads.rejectWith_target = MultiReaderHashBagTest::rejectWith_target;
            this.payloads.collectTarget = MultiReaderHashBagTest::collectTarget;
            this.payloads.collectBoolean = MultiReaderHashBagTest::collectBoolean;
            this.payloads.collectBooleanWithTarget = MultiReaderHashBagTest::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = MultiReaderHashBagTest::collectBooleanWithBagTarget;
            this.payloads.collectByte = MultiReaderHashBagTest::collectByte;
            this.payloads.collectByteWithTarget = MultiReaderHashBagTest::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = MultiReaderHashBagTest::collectByteWithBagTarget;
            this.payloads.collectChar = MultiReaderHashBagTest::collectChar;
            this.payloads.collectCharWithTarget = MultiReaderHashBagTest::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = MultiReaderHashBagTest::collectCharWithBagTarget;
            this.payloads.collectDouble = MultiReaderHashBagTest::collectDouble;
            this.payloads.collectDoubleWithTarget = MultiReaderHashBagTest::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = MultiReaderHashBagTest::collectDoubleWithBagTarget;
            this.payloads.collectFloat = MultiReaderHashBagTest::collectFloat;
            this.payloads.collectFloatWithTarget = MultiReaderHashBagTest::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = MultiReaderHashBagTest::collectFloatWithBagTarget;
            this.payloads.collectInt = MultiReaderHashBagTest::collectInt;
            this.payloads.collectIntWithTarget = MultiReaderHashBagTest::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = MultiReaderHashBagTest::collectIntWithBagTarget;
            this.payloads.collectLong = MultiReaderHashBagTest::collectLong;
            this.payloads.collectLongWithTarget = MultiReaderHashBagTest::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = MultiReaderHashBagTest::collectLongWithBagTarget;
            this.payloads.collectShort = MultiReaderHashBagTest::collectShort;
            this.payloads.collectShortWithTarget = MultiReaderHashBagTest::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = MultiReaderHashBagTest::collectShortWithBagTarget;
            this.payloads.flatCollectWith = MultiReaderHashBagTest::flatCollectWith;
            this.payloads.flatCollectBoolean = MultiReaderHashBagTest::flatCollectBoolean;
            this.payloads.flatCollectByte = MultiReaderHashBagTest::flatCollectByte;
            this.payloads.flatCollectShort = MultiReaderHashBagTest::flatCollectShort;
            this.payloads.flatCollectInt = MultiReaderHashBagTest::flatCollectInt;
            this.payloads.flatCollectChar = MultiReaderHashBagTest::flatCollectChar;
            this.payloads.flatCollectLong = MultiReaderHashBagTest::flatCollectLong;
            this.payloads.flatCollectDouble = MultiReaderHashBagTest::flatCollectDouble;
            this.payloads.flatCollectFloat = MultiReaderHashBagTest::flatCollectFloat;
            this.payloads.detect = MultiReaderHashBagTest::detect;
            this.payloads.detectOptional = MultiReaderHashBagTest::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = MultiReaderHashBagTest::min;
            this.payloads.minOptional = MultiReaderHashBagTest::minOptional;
            this.payloads.max = MultiReaderHashBagTest::max;
            this.payloads.maxOptional = MultiReaderHashBagTest::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = MultiReaderHashBagTest::min_without_comparator;
            this.payloads.max_without_comparator = MultiReaderHashBagTest::max_without_comparator;
            this.payloads.min_null_safe = MultiReaderHashBagTest::min_null_safe;
            this.payloads.max_null_safe = MultiReaderHashBagTest::max_null_safe;
            this.payloads.minBy = MultiReaderHashBagTest::minBy;
            this.payloads.minByOptional = MultiReaderHashBagTest::minByOptional;
            this.payloads.maxBy = MultiReaderHashBagTest::maxBy;
            this.payloads.maxByOptional = MultiReaderHashBagTest::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = MultiReaderHashBagTest::detectWith;
            this.payloads.detectWithOptional = MultiReaderHashBagTest::detectWithOptional;
            this.payloads.detectIfNone = MultiReaderHashBagTest::detectIfNone;
            this.payloads.detectWithIfNoneBlock = MultiReaderHashBagTest::detectWithIfNoneBlock;
            this.payloads.allSatisfy = MultiReaderHashBagTest::allSatisfy;
            this.payloads.allSatisfyWith = MultiReaderHashBagTest::allSatisfyWith;
            this.payloads.noneSatisfy = MultiReaderHashBagTest::noneSatisfy;
            this.payloads.noneSatisfyWith = MultiReaderHashBagTest::noneSatisfyWith;
            this.payloads.anySatisfy = MultiReaderHashBagTest::anySatisfy;
            this.payloads.anySatisfyWith = MultiReaderHashBagTest::anySatisfyWith;
            this.payloads.count = MultiReaderHashBagTest::count;
            this.payloads.countWith = MultiReaderHashBagTest::countWith;
            this.payloads.collectWith_target = MultiReaderHashBagTest::collectWith_target;
            this.payloads.getAny = MultiReaderHashBagTest::getAny;
            this.payloads.getFirst = MultiReaderHashBagTest::getFirst;
            this.payloads.getLast = MultiReaderHashBagTest::getLast;
            this.payloads.getOnly = MultiReaderHashBagTest::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.injectIntoInt = MultiReaderHashBagTest::injectIntoInt;
            this.payloads.injectIntoLong = MultiReaderHashBagTest::injectIntoLong;
            this.payloads.injectIntoDouble = MultiReaderHashBagTest::injectIntoDouble;
            this.payloads.injectIntoFloat = MultiReaderHashBagTest::injectIntoFloat;
            this.payloads.sumFloat = MultiReaderHashBagTest::sumFloat;
            this.payloads.summarizeFloat = MultiReaderHashBagTest::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = MultiReaderHashBagTest::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = MultiReaderHashBagTest::sumFloatConsistentRounding2;
            this.payloads.sumDouble = MultiReaderHashBagTest::sumDouble;
            this.payloads.summarizeDouble = MultiReaderHashBagTest::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = MultiReaderHashBagTest::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = MultiReaderHashBagTest::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = MultiReaderHashBagTest::sumInteger;
            this.payloads.summarizeInt = MultiReaderHashBagTest::summarizeInt;
            this.payloads.sumLong = MultiReaderHashBagTest::sumLong;
            this.payloads.summarizeLong = MultiReaderHashBagTest::summarizeLong;
            this.payloads.sumByInt = MultiReaderHashBagTest::sumByInt;
            this.payloads.sumByFloat = MultiReaderHashBagTest::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = MultiReaderHashBagTest::sumByFloatConsistentRounding;
            this.payloads.sumByLong = MultiReaderHashBagTest::sumByLong;
            this.payloads.sumByDouble = MultiReaderHashBagTest::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = MultiReaderHashBagTest::sumByDoubleConsistentRounding;
            this.payloads.toArray = MultiReaderHashBagTest::toArray;
            this.payloads.toImmutableList = MultiReaderHashBagTest::toImmutableList;
            this.payloads.toCollection = MultiReaderHashBagTest::toCollection;
            this.payloads.toBag = MultiReaderHashBagTest::toBag;
            this.payloads.toImmutableBag = MultiReaderHashBagTest::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = MultiReaderHashBagTest::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = MultiReaderHashBagTest::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = MultiReaderHashBagTest::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = MultiReaderHashBagTest::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = MultiReaderHashBagTest::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = MultiReaderHashBagTest::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = MultiReaderHashBagTest::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = MultiReaderHashBagTest::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = MultiReaderHashBagTest::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = MultiReaderHashBagTest::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = MultiReaderHashBagTest::toSortedListBy;
            this.payloads.toImmutableSortedListBy = MultiReaderHashBagTest::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = MultiReaderHashBagTest::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = MultiReaderHashBagTest::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = MultiReaderHashBagTest::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = MultiReaderHashBagTest::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = MultiReaderHashBagTest::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = MultiReaderHashBagTest::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = MultiReaderHashBagTest::toImmutableSet;
            this.payloads.toMap = MultiReaderHashBagTest::toMap;
            this.payloads.toImmutableMap = MultiReaderHashBagTest::toImmutableMap;
            this.payloads.toMapTarget = MultiReaderHashBagTest::toMapTarget;
            this.payloads.toSortedMap = MultiReaderHashBagTest::toSortedMap;
            this.payloads.toSortedMap_with_comparator = MultiReaderHashBagTest::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = MultiReaderHashBagTest::toSortedMapBy;
            this.payloads.toBiMap = MultiReaderHashBagTest::toBiMap;
            this.payloads.toImmutableBiMap = MultiReaderHashBagTest::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = MultiReaderHashBagTest::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = MultiReaderHashBagTest::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = MultiReaderHashBagTest::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = MultiReaderHashBagTest::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = MultiReaderHashBagTest::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = MultiReaderHashBagTest::appendStringThrows;
            this.payloads.countBy = MultiReaderHashBagTest::countBy;
            this.payloads.countByWith = MultiReaderHashBagTest::countByWith;
            this.payloads.countByEach = MultiReaderHashBagTest::countByEach;
            this.payloads.groupBy = MultiReaderHashBagTest::groupBy;
            this.payloads.groupByEach = MultiReaderHashBagTest::groupByEach;
            this.payloads.groupByUniqueKey = MultiReaderHashBagTest::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = MultiReaderHashBagTest::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = MultiReaderHashBagTest::zip;
            this.payloads.zipWithIndex = MultiReaderHashBagTest::zipWithIndex;
            this.payloads.chunk = MultiReaderHashBagTest::chunk;
            this.payloads.chunk_empty = MultiReaderHashBagTest::chunk_empty;
            this.payloads.chunk_single = MultiReaderHashBagTest::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = MultiReaderHashBagTest::chunk_large_size;
            this.payloads.empty = MultiReaderHashBagTest::empty;
            this.payloads.notEmpty = MultiReaderHashBagTest::notEmpty;
            this.payloads.aggregateByMutating = MultiReaderHashBagTest::aggregateByMutating;
            this.payloads.aggregateByNonMutating = MultiReaderHashBagTest::aggregateByNonMutating;
            this.payloads.reduceOptional = MultiReaderHashBagTest::reduceOptional;
            this.payloads.testNewWith = MultiReaderHashBagTest::testNewWith;
            this.payloads.testNewWithWith = MultiReaderHashBagTest::testNewWithWith;
            this.payloads.testNewWithWithWith = MultiReaderHashBagTest::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = MultiReaderHashBagTest::testNewWithVarArgs;
            this.payloads.addAll = MultiReaderHashBagTest::addAll;
            this.payloads.addAllIterable = MultiReaderHashBagTest::addAllIterable;
            this.payloads.removeAll = MultiReaderHashBagTest::removeAll;
            this.payloads.removeAllIterable = MultiReaderHashBagTest::removeAllIterable;
            this.payloads.retainAll = MultiReaderHashBagTest::retainAll;
            this.payloads.retainAllIterable = MultiReaderHashBagTest::retainAllIterable;
            this.payloads.clear = MultiReaderHashBagTest::clear;
            this.payloads.injectIntoWith = MultiReaderHashBagTest::injectIntoWith;
            this.payloads.removeObject = MultiReaderHashBagTest::removeObject;
            this.payloads.selectAndRejectWith = MultiReaderHashBagTest::selectAndRejectWith;
            this.payloads.removeIf = MultiReaderHashBagTest::removeIf;
            this.payloads.removeIfWith = MultiReaderHashBagTest::removeIfWith;
            this.payloads.asLazy = MultiReaderHashBagTest::asLazy;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::iterator_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.spliterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::spliterator_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.stream_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::stream_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.parallelStream_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::parallelStream_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.largeCollectionStreamToBagMultimap = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::largeCollectionStreamToBagMultimap, java.lang.UnsupportedOperationException.class);
            this.payloads.newEmpty = MultiReaderHashBagTest::newEmpty;
            this.payloads.hashBagNewWith = MultiReaderHashBagTest::hashBagNewWith;
            this.payloads.asSynchronized = MultiReaderHashBagTest::asSynchronized;
            this.payloads.asUnmodifiable = MultiReaderHashBagTest::asUnmodifiable;
            this.payloads.toImmutable = MultiReaderHashBagTest::toImmutable;
            this.payloads.addOccurrences = MultiReaderHashBagTest::addOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences = MultiReaderHashBagTest::removeOccurrences;
            this.payloads.setOccurrences = MultiReaderHashBagTest::setOccurrences;
            this.payloads.occurrencesOf = MultiReaderHashBagTest::occurrencesOf;
            this.payloads.sizeDistinct = MultiReaderHashBagTest::sizeDistinct;
            this.payloads.collect = MultiReaderHashBagTest::collect;
            this.payloads.flatCollect = MultiReaderHashBagTest::flatCollect;
            this.payloads.collectIf = MultiReaderHashBagTest::collectIf;
            this.payloads.collectWith = MultiReaderHashBagTest::collectWith;
            this.payloads.reject = MultiReaderHashBagTest::reject;
            this.payloads.rejectWith = MultiReaderHashBagTest::rejectWith;
            this.payloads.select = MultiReaderHashBagTest::select;
            this.payloads.selectWith = MultiReaderHashBagTest::selectWith;
            this.payloads.selectByOccurrences = MultiReaderHashBagTest::selectByOccurrences;
            this.payloads.selectDuplicates = MultiReaderHashBagTest::selectDuplicates;
            this.payloads.selectInstancesOf = MultiReaderHashBagTest::selectInstancesOf;
            this.payloads.partition = MultiReaderHashBagTest::partition;
            this.payloads.partitionWith = MultiReaderHashBagTest::partitionWith;
            this.payloads.with = MultiReaderHashBagTest::with;
            this.payloads.without = MultiReaderHashBagTest::without;
            this.payloads.withAll = MultiReaderHashBagTest::withAll;
            this.payloads.withoutAll = MultiReaderHashBagTest::withoutAll;
            this.payloads.toMapOfItemToCount = MultiReaderHashBagTest::toMapOfItemToCount;
            this.payloads.toStringOfItemToCount = MultiReaderHashBagTest::toStringOfItemToCount;
            this.payloads.forEachWithOccurrences = MultiReaderHashBagTest::forEachWithOccurrences;
            this.payloads.equalsAndHashCose = MultiReaderHashBagTest::equalsAndHashCose;
            this.payloads.toSet = MultiReaderHashBagTest::toSet;
            this.payloads.toList = MultiReaderHashBagTest::toList;
            this.payloads.injectInto = MultiReaderHashBagTest::injectInto;
            this.payloads.forEach = MultiReaderHashBagTest::forEach;
            this.payloads.isEmpty = MultiReaderHashBagTest::isEmpty;
            this.payloads.serialization = MultiReaderHashBagTest::serialization;
            this.payloads.withReadLockAndDelegate = MultiReaderHashBagTest::withReadLockAndDelegate;
            this.payloads.makeString = MultiReaderHashBagTest::makeString;
            this.payloads.appendString = MultiReaderHashBagTest::appendString;
            this.payloads.testToString = MultiReaderHashBagTest::testToString;
            this.payloads.iterator = MultiReaderHashBagTest::iterator;
            this.payloads.listIterator = new se.chalmers.ju2jmh.api.ExceptionTest<>(MultiReaderHashBagTest::listIterator, java.lang.UnsupportedOperationException.class);
            this.payloads.withWriteLockAndDelegate = MultiReaderHashBagTest::withWriteLockAndDelegate;
            this.payloads.concurrentWrite = MultiReaderHashBagTest::concurrentWrite;
            this.payloads.parallelCollect = MultiReaderHashBagTest::parallelCollect;
            this.payloads.selectUnique = MultiReaderHashBagTest::selectUnique;
            this.payloads.topOccurrences = MultiReaderHashBagTest::topOccurrences;
            this.payloads.bottomOccurrences = MultiReaderHashBagTest::bottomOccurrences;
            this.payloads.collectWithOccurrences = MultiReaderHashBagTest::collectWithOccurrences;
            this.payloads.collectWithOccurrencesWithTarget = MultiReaderHashBagTest::collectWithOccurrencesWithTarget;
        }
    }
}
