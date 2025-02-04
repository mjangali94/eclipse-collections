/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.bag.sorted.mutable;

import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.bag.MutableBagIterable;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.function.primitive.IntFunction;
import org.eclipse.collections.api.collection.MutableCollection;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.multimap.sortedbag.MutableSortedBagMultimap;
import org.eclipse.collections.api.partition.bag.sorted.PartitionMutableSortedBag;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.Twin;
import org.eclipse.collections.api.tuple.primitive.ObjectIntPair;
import org.eclipse.collections.impl.Counter;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.MutableBagTestCase;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions;
import org.eclipse.collections.impl.block.factory.IntegerPredicates;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.factory.PrimitiveFunctions;
import org.eclipse.collections.impl.block.factory.Procedures;
import org.eclipse.collections.impl.block.factory.primitive.IntPredicates;
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
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
import org.eclipse.collections.impl.math.IntegerSum;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.stack.mutable.ArrayStack;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.test.domain.Person;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link MutableSortedBag}s.
 *
 * @since 4.2
 */
public abstract class AbstractMutableSortedBagTestCase extends MutableBagTestCase {

    @Override
    protected abstract <T> MutableSortedBag<T> newWith(T... littleElements);

    @Override
    protected <T> MutableSortedBag<T> newWithOccurrences(ObjectIntPair<T>... elementsWithOccurrences) {
        MutableSortedBag<T> bag = this.newWith();
        for (ObjectIntPair<T> itemToAdd : elementsWithOccurrences) {
            bag.addOccurrences(itemToAdd.getOne(), itemToAdd.getTwo());
        }
        return bag;
    }

    protected abstract <T> MutableSortedBag<T> newWith(Comparator<? super T> comparator, T... elements);

    @Override
    @Test
    public void toImmutable() {
        super.toImmutable();
        Verify.assertInstanceOf(MutableSortedBag.class, this.newWith());
        Verify.assertInstanceOf(ImmutableSortedBag.class, this.newWith().toImmutable());
        Assert.assertFalse(this.newWith().toImmutable() instanceof MutableSortedBag);
        Assert.assertEquals(SortedBags.immutable.with(2, 2, 3), this.newWith(2, 2, 3).toImmutable());
    }

    @Test(expected = ClassCastException.class)
    public void toString_with_collection_containing_self() {
        MutableCollection<Object> collection = this.newWith(1);
        collection.add(collection);
        String simpleName = collection.getClass().getSimpleName();
        String string = collection.toString();
        Assert.assertTrue(("[1, (this " + simpleName + ")]").equals(string) || ("[(this " + simpleName + "), 1]").equals(string));
    }

    @Test(expected = ClassCastException.class)
    public void makeString_with_collection_containing_self() {
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        collection.add(collection);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test(expected = ClassCastException.class)
    public void appendString_with_collection_containing_self() {
        MutableCollection<Object> collection = this.newWith(1, 2, 3);
        collection.add(collection);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Override
    @Test
    public void addAll() {
        super.addAll();
        TreeBag<Integer> expected = TreeBag.newBag(Comparators.reverseNaturalOrder(), FastList.newListWith(1, 1, 2, 3));
        MutableSortedBag<Integer> collection = this.newWith(Comparators.reverseNaturalOrder());
        Assert.assertTrue(collection.addAll(FastList.newListWith(3, 2, 1, 1)));
        Verify.assertSortedBagsEqual(expected, collection);
    }

    @Override
    @Test
    public void addAllIterable() {
        super.addAllIterable();
        TreeBag<Integer> expected = TreeBag.newBag(Collections.reverseOrder(), FastList.newListWith(2, 1, 2, 3));
        MutableSortedBag<Integer> collection = this.newWith(Collections.reverseOrder());
        Assert.assertTrue(collection.addAllIterable(FastList.newListWith(3, 2, 1, 2)));
        Verify.assertSortedBagsEqual(expected, collection);
    }

    @Test
    public void testClone() {
        MutableSortedBag<Integer> set = this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3);
        MutableSortedBag<Integer> clone = set.clone();
        Assert.assertNotSame(set, clone);
        Verify.assertSortedBagsEqual(set, clone);
    }

    @Override
    @Test
    public void testToString() {
        super.testToString();
        Assert.assertEquals("[2, 1, 1]", this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2).toString());
        Assert.assertEquals("[3, 2, 1, 1]", this.newWith(Collections.reverseOrder(), 3, 1, 1, 2).toString());
        Assert.assertEquals("[-1, 2, 3]", this.newWith(3, -1, 2).toString());
    }

    @Override
    @Test
    public void makeString() {
        super.makeString();
        Assert.assertEquals("3, 3, 2", this.newWith(Comparators.reverseNaturalOrder(), 3, 2, 3).makeString());
    }

    @Override
    public void makeStringWithSeparator() {
        super.makeStringWithSeparator();
        Assert.assertEquals("3!2!-3", this.newWith(Comparators.reverseNaturalOrder(), 3, 2, -3).makeString("!"));
    }

    @Override
    public void makeStringWithSeparatorAndStartAndEnd() {
        super.makeStringWithSeparatorAndStartAndEnd();
        Assert.assertEquals("<1,2,3>", this.newWith(1, 2, 3).makeString("<", ",", ">"));
    }

    @Override
    @Test
    public void appendString() {
        super.appendString();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 5, 5, 1, 2, 3);
        Appendable builder = new StringBuilder();
        bag.appendString(builder);
        Assert.assertEquals(bag.toString(), "[" + builder + "]");
        Assert.assertEquals("5, 5, 3, 2, 1", builder.toString());
    }

    @Override
    public void appendStringWithSeparator() {
        super.appendStringWithSeparator();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 5, 5, 1, 2, 3);
        Appendable builder = new StringBuilder();
        bag.appendString(builder, ", ");
        Assert.assertEquals(bag.toString(), "[" + builder + "]");
        Assert.assertEquals("5, 5, 3, 2, 1", builder.toString());
    }

    @Override
    public void appendStringWithSeparatorAndStartAndEnd() {
        super.appendStringWithSeparatorAndStartAndEnd();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 5, 5, 1, 2, 3);
        Appendable builder = new StringBuilder();
        bag.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(bag.toString(), builder.toString());
        Assert.assertEquals("[5, 5, 3, 2, 1]", builder.toString());
    }

    @Override
    @Test
    public void removeObject() {
        super.removeObject();
        MutableSortedBag<String> bag = this.newWith(Collections.reverseOrder(), "5", "1", "2", "2", "3");
        Assert.assertFalse(bag.remove("7"));
        Assert.assertTrue(bag.remove("1"));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), "5", "3", "2", "2"), bag);
        Assert.assertTrue(bag.remove("2"));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), "5", "3", "2"), bag);
    }

    @Override
    @Test
    public void removeIf() {
        // Sorted containers don't support null
        MutableSortedBag<Integer> objects = this.newWith(Comparators.reverseNaturalOrder(), 4, 1, 3, 3, 2);
        Assert.assertTrue(objects.removeIf(Predicates.equal(2)));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 3, 3, 4), objects);
        Assert.assertTrue(objects.removeIf(Predicates.equal(3)));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 4), objects);
    }

    @Override
    @Test
    public void removeIfWith() {
        super.removeIfWith();
        MutableSortedBag<Integer> objects = this.newWith(Comparators.reverseNaturalOrder(), 4, 1, 3, 3, 2);
        Assert.assertTrue(objects.removeIfWith(Object::equals, 2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 3, 3, 4), objects);
        Assert.assertTrue(objects.removeIfWith(Object::equals, 3));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 4), objects);
    }

    @Override
    @Test
    public void equalsAndHashCode() {
        // Sorted containers don't support null
        MutableSortedBag<Integer> sortedBag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4);
        Verify.assertPostSerializedEqualsAndHashCode(sortedBag);
        Verify.assertEqualsAndHashCode(HashBag.newBag(sortedBag), sortedBag);
        Assert.assertNotEquals(HashBag.newBagWith(1, 1, 1, 2, 3, 4), sortedBag);
        Assert.assertNotEquals(HashBag.newBagWith(1, 1, 2, 3), sortedBag);
        Assert.assertNotEquals(HashBag.newBagWith(1, 2, 3, 4), sortedBag);
        Assert.assertNotEquals(HashBag.newBagWith(1, 2, 3, 4, 5), sortedBag);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4), sortedBag);
    }

    @Override
    @Test
    public void select() {
        super.select();
        MutableSortedBag<Integer> integers = this.newWith(3, 3, 2, 1, 4, 5);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(3, 3, 2, 1), integers.select(Predicates.lessThanOrEqualTo(3)));
        Verify.assertEmpty(integers.select(Predicates.greaterThan(6)));
        MutableSortedBag<Integer> revInt = this.newWith(Collections.reverseOrder(), 1, 2, 4, 3, 3, 5);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 3, 2, 1), revInt.select(Predicates.lessThan(4)));
    }

    @Override
    @Test
    public void selectWith() {
        super.selectWith();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 3), this.newWith(Comparators.reverseNaturalOrder(), 1, 3, 1, 2, 5, 3, 6, 6).selectWith(Predicates2.lessThan(), 4));
    }

    @Override
    @Test
    public void selectWith_target() {
        super.selectWith_target();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 3), this.newWith(Comparators.reverseNaturalOrder(), 1, 3, 1, 2, 5, 3, 6, 6).selectWith(Predicates2.lessThan(), 4, TreeBag.newBag(Comparators.reverseNaturalOrder())));
    }

    @Override
    @Test
    public void reject() {
        super.reject();
        MutableSortedBag<Integer> integers = this.newWith(4, 4, 2, 1, 3, 5, 6, 6);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4, 4), integers.reject(Predicates.greaterThan(4)));
        Verify.assertEmpty(integers.reject(Predicates.greaterThan(0)));
        MutableSortedBag<Integer> revInt = this.newWith(Collections.reverseOrder(), 1, 2, 2, 4, 3, 5);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 2, 2, 1), revInt.reject(Predicates.greaterThan(3)));
    }

    @Override
    @Test
    public void rejectWith() {
        super.rejectWith();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3), this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 5, 4, 5).rejectWith(Predicates2.greaterThan(), 3));
    }

    @Override
    @Test
    public void rejectWith_target() {
        super.rejectWith_target();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3), this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 5, 4, 5).rejectWith(Predicates2.greaterThan(), 3, TreeBag.newBag(Comparators.reverseNaturalOrder())));
    }

    @Override
    @Test
    public void partition() {
        super.partition();
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        PartitionMutableSortedBag<Integer> result = integers.partition(IntegerPredicates.isEven());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 2, 2), result.getSelected());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 1), result.getRejected());
    }

    @Override
    @Test
    public void partitionWith() {
        super.partitionWith();
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        PartitionMutableSortedBag<Integer> result = integers.partitionWith(Predicates2.in(), integers.select(IntegerPredicates.isEven()));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 2, 2, 4, 4, 4, 4), result.getSelected());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 1, 3, 3, 3), result.getRejected());
    }

    @Test
    public void partitionWhile() {
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 4, 2, 1, 3, 5, 6);
        PartitionMutableSortedBag<Integer> partition = integers.partitionWhile(Predicates.greaterThan(3));
        Verify.assertSortedBagsEqual(this.newWith(Comparators.reverseNaturalOrder(), 6, 5, 4), partition.getSelected());
        Verify.assertSortedBagsEqual(this.newWith(Comparators.reverseNaturalOrder(), 3, 2, 1), partition.getRejected());
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), partition.getSelected().comparator());
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), partition.getRejected().comparator());
    }

    @Override
    @Test
    public void selectAndRejectWith() {
        super.selectAndRejectWith();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 1, 1, 1, 1, 2);
        Twin<MutableList<Integer>> result = bag.selectAndRejectWith(Object::equals, 1);
        Verify.assertSize(4, result.getOne());
        Verify.assertSize(1, result.getTwo());
    }

    @Override
    @Test
    public void collect() {
        super.collect();
        MutableSortedBag<Integer> integers = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 3, 1, 1);
        MutableList<Holder> holders = integers.collect(Holder::new);
        Assert.assertEquals(FastList.newListWith(new Holder(4), new Holder(3), new Holder(1), new Holder(1)), holders);
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndex() {
        MutableSortedBag<Integer> integers = this.newWith(Collections.reverseOrder(), 1, 1, 2);
        MutableList<ObjectIntPair<Integer>> expected = Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(2), 0), PrimitiveTuples.pair(Integer.valueOf(1), 1), PrimitiveTuples.pair(Integer.valueOf(1), 2));
        Verify.assertListsEqual(expected, integers.collectWithIndex(PrimitiveTuples::pair));
    }

    /**
     * @since 9.1.
     */
    @Test
    public void collectWithIndexWithTarget() {
        MutableSortedBag<Integer> integers = this.newWith(Collections.reverseOrder(), 1, 1, 2);
        MutableList<ObjectIntPair<Integer>> expected = Lists.mutable.with(PrimitiveTuples.pair(Integer.valueOf(2), 0), PrimitiveTuples.pair(Integer.valueOf(1), 1), PrimitiveTuples.pair(Integer.valueOf(1), 2));
        Verify.assertListsEqual(expected, integers.collectWithIndex(PrimitiveTuples::pair, Lists.mutable.empty()));
    }

    @Override
    @Test
    public void flatCollect() {
        super.flatCollect();
        MutableSortedBag<Integer> integers = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 3, 1, 1);
        MutableList<Holder> holders = integers.flatCollect(Holder.FROM_LIST);
        Assert.assertEquals(FastList.newListWith(new Holder(4), new Holder(4), new Holder(3), new Holder(3), new Holder(1), new Holder(1), new Holder(1), new Holder(1)), holders);
    }

    @Test
    public void distinct() {
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3, 4);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 4, 3, 2, 1), integers.distinct());
    }

    @Test
    public void takeWhile() {
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3, 4, 4);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 4), integers.takeWhile(IntegerPredicates.isEven()));
        Verify.assertSortedBagsEqual(TreeBag.newBag(Comparators.reverseNaturalOrder()), integers.takeWhile(IntegerPredicates.isOdd()));
        MutableSortedBag<Integer> take = integers.takeWhile(Predicates.greaterThan(2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 4, 3, 3), take);
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), take.comparator());
    }

    @Test
    public void dropWhile() {
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 3, 3, 4, 4);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 3, 3, 2, 2, 1, 1), integers.dropWhile(IntegerPredicates.isEven()));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 4, 3, 3, 2, 2, 1, 1), integers.dropWhile(IntegerPredicates.isOdd()));
        MutableSortedBag<Integer> drop = integers.dropWhile(Predicates.greaterThan(2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 2, 2, 1, 1), drop);
        Assert.assertEquals(Comparators.<Integer>reverseNaturalOrder(), drop.comparator());
    }

    @Override
    @Test
    public void collectIf() {
        super.collectIf();
        Assert.assertEquals(this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3, 4, 5, 5).collectIf(Predicates.lessThan(4), Holder::new), FastList.newListWith(new Holder(3), new Holder(2), new Holder(1), new Holder(1), new Holder(1)));
    }

    @Override
    @Test
    public void collectWith() {
        super.collectWith();
        MutableSortedBag<Integer> integers = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 3, 1, 1);
        MutableList<Holder> holders = integers.collectWith(Holder.FROM_INT_INT, 10);
        Assert.assertEquals(FastList.newListWith(new Holder(14), new Holder(13), new Holder(11), new Holder(11)), holders);
    }

    @Override
    @Test
    public void collectWith_target() {
        super.collectWith_target();
        MutableSortedBag<Integer> integers = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 4, 3, 1, 1);
        MutableSortedBag<Holder> holders = integers.collectWith(Holder.FROM_INT_INT, 10, TreeBag.newBag(Functions.toIntComparator(Holder.TO_NUMBER)));
        Assert.assertEquals(TreeBag.newBagWith(Functions.toIntComparator(Holder.TO_NUMBER), new Holder(14), new Holder(13), new Holder(11), new Holder(11)), holders);
    }

    @Override
    @Test
    public void groupBy() {
        super.groupBy();
        MutableSortedBag<Integer> integers = this.newWith(Collections.reverseOrder(), 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        MutableSortedBagMultimap<Boolean, Integer> map = integers.groupBy(isOddFunction);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 9, 7, 5, 3, 1, 1, 1), map.get(Boolean.TRUE));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 8, 6, 4, 2), map.get(Boolean.FALSE));
        Verify.assertSize(2, map.keysView().toList());
    }

    @Override
    @Test
    public void groupByEach() {
        super.groupByEach();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 1, 1, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        MutableSortedBagMultimap<Integer, Integer> expected = this.newWith(Collections.<Integer>reverseOrder()).groupByEach(function);
        for (int i = 1; i < 10; i++) {
            expected.putAll(-i, Interval.fromTo(i, 9));
        }
        expected.put(-1, 1);
        expected.put(-1, 1);
        MutableSortedBagMultimap<Integer, Integer> actual = bag.groupByEach(function);
        Assert.assertEquals(expected, actual);
        MutableSortedBagMultimap<Integer, Integer> actualWithTarget = bag.groupByEach(function, this.<Integer>newWith().groupByEach(function));
        Assert.assertEquals(expected, actualWithTarget);
        for (int i = 1; i < 10; ++i) {
            Verify.assertSortedBagsEqual(expected.get(-i), actual.get(-i));
        }
        Verify.assertSize(9, actual.keysView().toList());
        Verify.assertSize(9, actualWithTarget.keysView().toList());
    }

    @Override
    @Test
    public void zip() {
        super.zip();
        MutableSortedBag<Integer> revInt = this.newWith(Collections.reverseOrder(), 2, 2, 3, 5, 1, 4);
        MutableSortedBag<Integer> integers = this.newWith(1, 3, 2, 2, 4, 5);
        MutableList<Pair<Integer, Integer>> zip = integers.zip(revInt);
        Verify.assertSize(6, zip);
        Assert.assertEquals(FastList.newListWith(Tuples.pair(1, 5), Tuples.pair(2, 4), Tuples.pair(2, 3), Tuples.pair(3, 2), Tuples.pair(4, 2), Tuples.pair(5, 1)), zip);
        MutableList<Pair<Integer, Integer>> revZip = revInt.zip(integers);
        Verify.assertSize(6, revZip);
        Assert.assertEquals(FastList.newListWith(Tuples.pair(5, 1), Tuples.pair(4, 2), Tuples.pair(3, 2), Tuples.pair(2, 3), Tuples.pair(2, 4), Tuples.pair(1, 5)), revZip);
        Person john = new Person("John", "Smith");
        Person johnDoe = new Person("John", "Doe");
        MutableSortedBag<Person> people = this.newWith(john, johnDoe);
        MutableList<Integer> list = FastList.newListWith(1, 2, 3);
        MutableList<Pair<Person, Integer>> pairs = people.zip(list);
        Assert.assertEquals(FastList.newListWith(Tuples.pair(johnDoe, 1), Tuples.pair(john, 2)), pairs);
        Assert.assertTrue(pairs.add(Tuples.pair(new Person("Jack", "Baker"), 3)));
        Assert.assertEquals(Tuples.pair(new Person("Jack", "Baker"), 3), pairs.getLast());
    }

    @Override
    @Test
    public void zipWithIndex() {
        super.zipWithIndex();
        MutableSortedBag<Integer> integers = this.newWith(Collections.reverseOrder(), 1, 3, 5, 5, 5, 2, 4);
        Assert.assertEquals(UnifiedSet.newSetWith(Tuples.pair(5, 0), Tuples.pair(5, 1), Tuples.pair(5, 2), Tuples.pair(4, 3), Tuples.pair(3, 4), Tuples.pair(2, 5), Tuples.pair(1, 6)), integers.zipWithIndex());
    }

    @Override
    public void selectInstancesOf() {
        MutableSortedBag<Number> numbers = this.newWith((Number o1, Number o2) -> Double.compare(o2.doubleValue(), o1.doubleValue()), 5, 4.0, 3, 2.0, 1, 1);
        MutableSortedBag<Integer> integers = numbers.selectInstancesOf(Integer.class);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 5, 3, 1, 1), integers);
    }

    @Override
    @Test
    public void toStringOfItemToCount() {
        super.toStringOfItemToCount();
        Assert.assertEquals("{}", this.newWith().toStringOfItemToCount());
        Assert.assertEquals("{}", this.newWith(Comparators.reverseNaturalOrder()).toStringOfItemToCount());
        Assert.assertEquals("{1=1, 2=2}", this.newWith(1, 2, 2).toStringOfItemToCount());
        Assert.assertEquals("{2=2, 1=1}", this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 2).toStringOfItemToCount());
    }

    @Override
    @Test
    public void add() {
        super.add();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder());
        Assert.assertTrue(bag.add(1));
        Verify.assertSortedBagsEqual(this.newWith(1), bag);
        Assert.assertTrue(bag.add(3));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 1), bag);
        Verify.assertSize(2, bag);
        Assert.assertTrue(bag.add(2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 2, 1), bag);
        Verify.assertSize(3, bag);
        Assert.assertTrue(bag.add(2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 2, 2, 1), bag);
        Verify.assertSize(4, bag);
    }

    @Override
    @Test
    public void iterator() {
        super.iterator();
        MutableSortedBag<Integer> bag = this.newWith(-1, 0, 1, 1, 2);
        Iterator<Integer> iterator = bag.iterator();
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(-1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(0), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), iterator.next());
        Assert.assertTrue(iterator.hasNext());
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
        Assert.assertFalse(iterator.hasNext());
        MutableSortedBag<Integer> revBag = this.newWith(Comparators.reverseNaturalOrder(), -1, 0, 1, 1, 2);
        Iterator<Integer> revIterator = revBag.iterator();
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(2), revIterator.next());
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), revIterator.next());
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(1), revIterator.next());
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(0), revIterator.next());
        Assert.assertTrue(revIterator.hasNext());
        Assert.assertEquals(Integer.valueOf(-1), revIterator.next());
        Assert.assertFalse(revIterator.hasNext());
        MutableSortedBag<Integer> sortedBag = this.newWith(Collections.reverseOrder(), 1, 1, 1, 1, 2);
        MutableList<Integer> validate = Lists.mutable.empty();
        for (Integer each : sortedBag) {
            validate.add(each);
        }
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 1, 1, 1, 1, 2), TreeBag.newBag(Collections.reverseOrder(), validate));
        Iterator<Integer> sortedBagIterator = sortedBag.iterator();
        MutableSortedBag<Integer> expected = this.newWith(Collections.reverseOrder(), 1, 1, 1, 1, 2);
        Assert.assertThrows(IllegalStateException.class, sortedBagIterator::remove);
        this.assertIteratorRemove(sortedBag, sortedBagIterator, expected);
        this.assertIteratorRemove(sortedBag, sortedBagIterator, expected);
        this.assertIteratorRemove(sortedBag, sortedBagIterator, expected);
        this.assertIteratorRemove(sortedBag, sortedBagIterator, expected);
        this.assertIteratorRemove(sortedBag, sortedBagIterator, expected);
        Verify.assertEmpty(sortedBag);
        Assert.assertFalse(sortedBagIterator.hasNext());
        Assert.assertThrows(NoSuchElementException.class, sortedBagIterator::next);
    }

    private void assertIteratorRemove(MutableSortedBag<Integer> bag, Iterator<Integer> iterator, MutableSortedBag<Integer> expected) {
        Assert.assertTrue(iterator.hasNext());
        Integer first = iterator.next();
        iterator.remove();
        expected.remove(first);
        Verify.assertSortedBagsEqual(expected, bag);
        Assert.assertThrows(IllegalStateException.class, iterator::remove);
    }

    @Override
    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        super.iterator_throws();
        MutableSortedBag<Integer> revBag = this.newWith(Comparators.reverseNaturalOrder(), -1, 0, 1, 1, 2);
        Iterator<Integer> revIterator = revBag.iterator();
        Assert.assertTrue(revIterator.hasNext());
        revIterator.next();
        Assert.assertTrue(revIterator.hasNext());
        revIterator.next();
        Assert.assertTrue(revIterator.hasNext());
        revIterator.next();
        Assert.assertTrue(revIterator.hasNext());
        revIterator.next();
        Assert.assertTrue(revIterator.hasNext());
        revIterator.next();
        Assert.assertFalse(revIterator.hasNext());
        revIterator.next();
    }

    @Override
    @Test
    public void tap() {
        super.tap();
        MutableList<Integer> tapResult = FastList.newList();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 1, 1, 2);
        Assert.assertSame(bag, bag.tap(tapResult::add));
        Assert.assertEquals(bag.toList(), tapResult);
    }

    @Override
    @Test
    public void forEach() {
        super.forEach();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 1, 1, 2);
        MutableList<Integer> actual = FastList.newList();
        bag.forEach(Procedures.cast(actual::add));
        Assert.assertEquals(FastList.newListWith(2, 1, 1), actual);
    }

    @Test
    public void forEachFromTo() {
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        MutableList<Integer> result = Lists.mutable.empty();
        integers.forEach(5, 7, result::add);
        Assert.assertEquals(Lists.immutable.with(3, 3, 2), result);
        MutableList<Integer> result2 = Lists.mutable.empty();
        integers.forEach(5, 5, result2::add);
        Assert.assertEquals(Lists.immutable.with(3), result2);
        MutableList<Integer> result3 = Lists.mutable.empty();
        integers.forEach(0, 9, result3::add);
        Assert.assertEquals(Lists.immutable.with(4, 4, 4, 4, 3, 3, 3, 2, 2, 1), result3);
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(-1, 0, result::add));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEach(0, -1, result::add));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.forEach(7, 5, result::add));
    }

    @Test
    public void forEachWithIndexWithFromTo() {
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        StringBuilder builder = new StringBuilder();
        integers.forEachWithIndex(5, 7, (each, index) -> builder.append(each).append(index));
        Assert.assertEquals("353627", builder.toString());
        StringBuilder builder2 = new StringBuilder();
        integers.forEachWithIndex(5, 5, (each, index) -> builder2.append(each).append(index));
        Assert.assertEquals("35", builder2.toString());
        StringBuilder builder3 = new StringBuilder();
        integers.forEachWithIndex(0, 9, (each, index) -> builder3.append(each).append(index));
        Assert.assertEquals("40414243343536272819", builder3.toString());
        MutableList<Integer> result = Lists.mutable.empty();
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(-1, 0, new AddToList(result)));
        Assert.assertThrows(IndexOutOfBoundsException.class, () -> integers.forEachWithIndex(0, -1, new AddToList(result)));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.forEachWithIndex(7, 5, new AddToList(result)));
    }

    @Override
    @Test
    public void forEachWithOccurrences() {
        super.forEachWithOccurrences();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 3, 3, 3, 2, 2, 1);
        MutableList<Integer> actualItems = FastList.newList();
        MutableList<Integer> actualIndexes = FastList.newList();
        bag.forEachWithOccurrences((each, index) -> {
            actualItems.add(each);
            actualIndexes.add(index);
        });
        Assert.assertEquals(FastList.newListWith(3, 2, 1), actualItems);
        Assert.assertEquals(FastList.newListWith(3, 2, 1), actualIndexes);
        MutableSortedBag<Integer> bag2 = this.newWith();
        bag2.addOccurrences(1, 10);
        bag2.addOccurrences(2, 10);
        bag2.addOccurrences(3, 10);
        IntegerSum sum = new IntegerSum(0);
        Counter counter = new Counter();
        bag2.forEachWithOccurrences((each, occurrences) -> {
            counter.increment();
            sum.add(each * occurrences * counter.getCount());
        });
        Assert.assertEquals(140, sum.getIntSum());
        bag2.removeOccurrences(2, 1);
        IntegerSum sum2 = new IntegerSum(0);
        bag2.forEachWithOccurrences((each, occurrences) -> sum2.add(each * occurrences));
        Assert.assertEquals(58, sum2.getIntSum());
        bag2.removeOccurrences(1, 3);
        IntegerSum sum3 = new IntegerSum(0);
        bag2.forEachWithOccurrences((each, occurrences) -> sum3.add(each * occurrences));
        Assert.assertEquals(55, sum3.getIntSum());
    }

    @Test
    @Override
    public void getFirst() {
        super.getFirst();
        Assert.assertEquals(Integer.valueOf(0), this.newWith(0, 0, 1, 1).getFirst());
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 1, 2, 3).getFirst());
        Assert.assertEquals(Integer.valueOf(1), this.newWith(2, 1, 3, 2, 3).getFirst());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(Collections.reverseOrder(), 2, 2, 1, 3).getFirst());
    }

    @Test
    @Override
    public void getLast() {
        super.getLast();
        Assert.assertEquals(Integer.valueOf(1), this.newWith(0, 0, 1, 1).getLast());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 1, 2, 3).getLast());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(3, 2, 3, 2, 3).getLast());
        Assert.assertEquals(Integer.valueOf(1), this.newWith(Collections.reverseOrder(), 2, 2, 1, 3).getLast());
    }

    @Test
    public void indexOf() {
        MutableSortedBag<Integer> integers = this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        Assert.assertEquals(0, integers.indexOf(4));
        Assert.assertEquals(4, integers.indexOf(3));
        Assert.assertEquals(7, integers.indexOf(2));
        Assert.assertEquals(9, integers.indexOf(1));
        Assert.assertEquals(-1, integers.indexOf(0));
    }

    @Override
    @Test
    public void occurrencesOf() {
        super.occurrencesOf();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 1, 1, 2);
        Assert.assertEquals(2, bag.occurrencesOf(1));
        Assert.assertEquals(1, bag.occurrencesOf(2));
    }

    @Override
    @Test
    public void addOccurrences() {
        super.addOccurrences();
        MutableSortedBag<Integer> bag = this.newWith();
        Assert.assertEquals(3, bag.addOccurrences(0, 3));
        Assert.assertEquals(0, bag.addOccurrences(2, 0));
        Assert.assertEquals(2, bag.addOccurrences(1, 2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(0, 0, 0, 1, 1), bag);
        Assert.assertEquals(6, bag.addOccurrences(0, 3));
        Assert.assertEquals(4, bag.addOccurrences(1, 2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(0, 0, 0, 0, 0, 0, 1, 1, 1, 1), bag);
        MutableSortedBag<Integer> revBag = this.newWith(Collections.reverseOrder());
        Assert.assertEquals(3, revBag.addOccurrences(2, 3));
        Assert.assertEquals(2, revBag.addOccurrences(3, 2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 3, 2, 2, 2), revBag);
        Assert.assertEquals(6, revBag.addOccurrences(2, 3));
        Assert.assertEquals(4, revBag.addOccurrences(3, 2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 3, 3, 3, 2, 2, 2, 2, 2, 2), revBag);
    }

    @Override
    @Test
    public void removeOccurrences() {
        super.removeOccurrences();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 2, 2, 1);
        MutableSortedBag<Integer> expected = TreeBag.newBag(bag);
        Assert.assertFalse(bag.removeOccurrences(4, 2));
        Assert.assertFalse(bag.removeOccurrences(4, 0));
        Assert.assertFalse(bag.removeOccurrences(2, 0));
        Verify.assertSortedBagsEqual(expected, bag);
        Assert.assertTrue(bag.removeOccurrences(2, 2));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1), bag);
        Assert.assertTrue(bag.removeOccurrences(1, 100));
        Verify.assertSortedBagsEqual(TreeBag.<String>newBag(), bag);
    }

    @Override
    @Test
    public void toList() {
        super.toList();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 3, 3, 2);
        Assert.assertEquals(FastList.newListWith(3, 3, 2, 1), bag.toList());
    }

    @Override
    @Test
    public void toSet() {
        super.toSet();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3), bag.toSet());
    }

    @Override
    @Test
    public void toBag() {
        super.toBag();
        Assert.assertEquals(Bags.mutable.of("C", "C", "B", "A"), this.newWith(Comparators.reverseNaturalOrder(), "C", "C", "B", "A").toBag());
    }

    @Test
    public void toStack() {
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 3, 3, 2);
        Assert.assertEquals(ArrayStack.newStackFromTopToBottom(1, 2, 3, 3), bag.toStack());
    }

    @Override
    @Test
    public void toSortedList_natural_ordering() {
        super.toSortedList_natural_ordering();
        Assert.assertEquals(FastList.newListWith(1, 2, 3, 4, 4), this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 3, 1, 2).toSortedList());
    }

    @Override
    @Test
    public void toSortedList_with_comparator() {
        super.toSortedList_with_comparator();
        Assert.assertEquals(FastList.newListWith(4, 4, 3, 2, 1), this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 3, 1, 2).toSortedList(Comparators.reverseNaturalOrder()));
    }

    @Override
    @Test
    public void toSortedListBy() {
        super.toSortedListBy();
        MutableSortedBag<Integer> sortedBag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 10, 2, 3);
        MutableList<Integer> sortedListBy = sortedBag.toSortedListBy(String::valueOf);
        Assert.assertEquals(FastList.newListWith(1, 1, 1, 10, 2, 3), sortedListBy);
    }

    @Override
    @Test
    public void toSortedSet_natural_ordering() {
        super.toSortedSet_natural_ordering();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 2, 2, 1, 5, 4);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 4, 5), bag.toSortedSet());
    }

    @Override
    @Test
    public void toSortedSet_with_comparator() {
        super.toSortedSet_with_comparator();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 2, 2, 1, 5, 4);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), 5, 4, 2, 1), bag.toSortedSet(Comparators.reverseNaturalOrder()));
    }

    @Override
    @Test
    public void toSortedSetBy() {
        super.toSortedSetBy();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 2, 5, 2, 4, 3, 1, 6, 7, 8, 9, 10);
        Assert.assertEquals(UnifiedSet.newSetWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10), bag.toSortedSetBy(String::valueOf));
        Assert.assertEquals(FastList.newListWith(1, 10, 2, 3, 4, 5, 6, 7, 8, 9), bag.toSortedSetBy(String::valueOf).toList());
    }

    @Override
    @Test
    public void toMap() {
        super.toMap();
        Assert.assertEquals(UnifiedMap.newWithKeysValues("4", "4", "3", "3", "2", "2", "1", "1"), this.newWith(Comparators.reverseNaturalOrder(), 4, 3, 2, 1).toMap(String::valueOf, String::valueOf));
    }

    @Override
    @Test
    public void toSortedMap() {
        super.toSortedMap();
        Verify.assertSortedMapsEqual(TreeSortedMap.newMapWith(3, "3", 2, "2", 1, "1"), this.newWith(3, 2, 1).toSortedMap(Functions.getIntegerPassThru(), String::valueOf));
    }

    @Override
    @Test
    public void toSortedMap_with_comparator() {
        super.toSortedMap_with_comparator();
        Verify.assertSortedMapsEqual(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), 3, "3", 2, "2", 1, "1"), this.newWith(3, 2, 1, 1).toSortedMap(Comparators.reverseNaturalOrder(), Functions.getIntegerPassThru(), String::valueOf));
    }

    @Override
    @Test
    public void toSortedMapBy() {
        super.toSortedMapBy();
        Verify.assertSortedMapsEqual(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), 3, "3", 2, "2", 1, "1"), this.newWith(3, 2, 1, 1).toSortedMapBy(key -> -key, Functions.getIntegerPassThru(), String::valueOf));
    }

    @Override
    @Test
    public void asUnmodifiable() {
        Verify.assertInstanceOf(UnmodifiableSortedBag.class, this.newWith().asUnmodifiable());
        Verify.assertSortedBagsEqual(this.newWith(), this.newWith().asUnmodifiable());
    }

    @Override
    @Test
    public void serialization() {
        super.serialization();
        MutableSortedBag<String> bag = this.newWith(Comparators.reverseNaturalOrder(), "One", "Two", "Two", "Three", "Three", "Three");
        Verify.assertPostSerializedEqualsAndHashCode(bag);
        Assert.assertNotNull(bag.comparator());
    }

    @Override
    @Test
    public void selectByOccurrences() {
        super.selectByOccurrences();
        MutableSortedBag<Integer> integers = this.newWith(Collections.reverseOrder(), 4, 3, 3, 2, 2, 2, 1, 1, 1, 1);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 3, 1, 1, 1, 1), integers.selectByOccurrences(IntPredicates.isEven()));
    }

    @Override
    @Test
    public void selectDuplicates() {
        super.selectDuplicates();
        MutableSortedBag<Integer> integers = this.newWith(Collections.reverseOrder(), 5, 4, 3, 3, 2, 2, 2, 1, 1, 1, 1, 0);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 3, 3, 2, 2, 2, 1, 1, 1, 1), integers.selectDuplicates());
    }

    @Override
    @Test
    public void toMapOfItemToCount() {
        super.toMapOfItemToCount();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 1, 2, 2, 3, 3, 3);
        Assert.assertEquals(TreeSortedMap.newMapWith(Collections.reverseOrder(), 1, 1, 2, 2, 3, 3), bag.toMapOfItemToCount());
    }

    @Test
    public void compareTo() {
        Assert.assertEquals(-1, this.newWith(1, 1, 2, 2).compareTo(this.newWith(1, 1, 2, 2, 2)));
        Assert.assertEquals(0, this.newWith(1, 1, 2, 2).compareTo(this.newWith(1, 1, 2, 2)));
        Assert.assertEquals(1, this.newWith(1, 1, 2, 2, 2).compareTo(this.newWith(1, 1, 2, 2)));
        Assert.assertEquals(-1, this.newWith(1, 1, 2, 2).compareTo(this.newWith(1, 1, 3, 3)));
        Assert.assertEquals(1, this.newWith(1, 1, 3, 3).compareTo(this.newWith(1, 1, 2, 2)));
        Assert.assertEquals(1, this.newWith(Comparators.reverseNaturalOrder(), 2, 2, 1, 1, 1).compareTo(this.newWith(Comparators.reverseNaturalOrder(), 2, 2, 1, 1)));
        Assert.assertEquals(1, this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2).compareTo(this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 2)));
        Assert.assertEquals(0, this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2).compareTo(this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2)));
        Assert.assertEquals(-1, this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2, 2).compareTo(this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2)));
        Assert.assertEquals(1, this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2).compareTo(this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 3, 3)));
        Assert.assertEquals(-1, this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 3, 3).compareTo(this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 2)));
    }

    @Override
    @Test
    public void containsAllIterable() {
        super.containsAllIterable();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4);
        Assert.assertTrue(bag.containsAllIterable(FastList.newListWith(1, 2)));
        Assert.assertFalse(bag.containsAllIterable(FastList.newListWith(1, 5)));
        Assert.assertTrue(bag.containsAllIterable(FastList.newListWith()));
    }

    @Override
    @Test
    public void containsAllArray() {
        super.containsAllArray();
        MutableSortedBag<Integer> collection = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3, 4);
        Assert.assertTrue(collection.containsAllArguments(1, 2));
        Assert.assertFalse(collection.containsAllArguments(1, 5));
        Assert.assertTrue(collection.containsAllArguments());
    }

    @Override
    @Test
    public void forEachWith() {
        super.forEachWith();
        MutableSortedBag<String> bag = this.newWith(Collections.reverseOrder(), "1", "2", "2", "3", "4");
        StringBuilder builder = new StringBuilder();
        bag.forEachWith((argument1, argument2) -> builder.append(argument1).append(argument2), 0);
        Assert.assertEquals("4030202010", builder.toString());
    }

    @Override
    @Test
    public void forEachWithIndex() {
        super.forEachWithIndex();
        MutableSortedBag<String> bag = this.newWith(Collections.reverseOrder(), "1", "2", "2", "3", "4");
        StringBuilder builder = new StringBuilder();
        bag.forEachWithIndex((each, index) -> builder.append(each).append(index));
        Assert.assertEquals("4031222314", builder.toString());
    }

    @Override
    @Test
    public void collectBoolean() {
        super.collectBoolean();
        MutableSortedBag<String> bag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "true", "nah", "TrUe");
        Assert.assertEquals(BooleanArrayList.newListWith(true, false, true), bag.collectBoolean(Boolean::parseBoolean));
    }

    @Override
    @Test
    public void collectByte() {
        super.collectByte();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(ByteArrayList.newListWith((byte) 3, (byte) 2, (byte) 1, (byte) 1, (byte) 1), bag.collectByte(PrimitiveFunctions.unboxIntegerToByte()));
    }

    @Override
    @Test
    public void collectChar() {
        super.collectChar();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(CharArrayList.newListWith((char) 3, (char) 2, (char) 1, (char) 1, (char) 1), bag.collectChar(PrimitiveFunctions.unboxIntegerToChar()));
    }

    @Override
    @Test
    public void collectDouble() {
        super.collectDouble();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(DoubleArrayList.newListWith(3, 2, 1, 1, 1), bag.collectDouble(PrimitiveFunctions.unboxIntegerToDouble()));
    }

    @Override
    @Test
    public void collectFloat() {
        super.collectFloat();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(FloatArrayList.newListWith(3, 2, 1, 1, 1), bag.collectFloat(PrimitiveFunctions.unboxIntegerToFloat()));
    }

    @Override
    @Test
    public void collectInt() {
        super.collectInt();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(IntArrayList.newListWith(3, 2, 1, 1, 1), bag.collectInt(PrimitiveFunctions.unboxIntegerToInt()));
    }

    @Override
    @Test
    public void collectLong() {
        super.collectLong();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(LongArrayList.newListWith(3, 2, 1, 1, 1), bag.collectLong(PrimitiveFunctions.unboxIntegerToLong()));
    }

    @Override
    @Test
    public void collectShort() {
        super.collectShort();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(ShortArrayList.newListWith((short) 3, (short) 2, (short) 1, (short) 1, (short) 1), bag.collectShort(PrimitiveFunctions.unboxIntegerToShort()));
    }

    @Override
    @Test
    public void detect() {
        super.detect();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3);
        Assert.assertEquals(Integer.valueOf(2), bag.detect(Predicates.lessThan(3)));
        Assert.assertNull(bag.detect(Integer.valueOf(4)::equals));
    }

    @Override
    @Test
    public void min() {
        super.min();
        Assert.assertEquals(Integer.valueOf(1), this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4).min());
        Assert.assertEquals(Integer.valueOf(4), this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4).min(Comparators.reverseNaturalOrder()));
    }

    @Override
    @Test
    public void max() {
        super.max();
        Assert.assertEquals(Integer.valueOf(1), this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4).min());
        Assert.assertEquals(Integer.valueOf(4), this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3, 4).min(Comparators.reverseNaturalOrder()));
    }

    @Override
    @Test
    public void minBy() {
        super.minBy();
        Assert.assertEquals(Integer.valueOf(1), this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 3).minBy(String::valueOf));
    }

    @Override
    @Test
    public void maxBy() {
        super.maxBy();
        Assert.assertEquals(Integer.valueOf(3), this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3).maxBy(String::valueOf));
    }

    @Override
    @Test
    public void detectWith() {
        super.detectWith();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 4, 5);
        Assert.assertEquals(Integer.valueOf(5), bag.detectWith(Predicates2.greaterThan(), 3));
        Assert.assertEquals(Integer.valueOf(2), bag.detectWith(Predicates2.lessThan(), 3));
        Assert.assertNull(this.newWith(1, 2, 3, 4, 5).detectWith(Object::equals, 6));
    }

    @Override
    @Test
    public void detectIfNone() {
        super.detectIfNone();
        Function0<Integer> function = new PassThruFunction0<>(6);
        Assert.assertEquals(Integer.valueOf(3), this.newWith(Comparators.reverseNaturalOrder(), 2, 3, 4, 5).detectIfNone(Integer.valueOf(3)::equals, function));
        Assert.assertEquals(Integer.valueOf(3), this.newWith(Comparators.reverseNaturalOrder(), 2, 3, 4, 5).detectIfNone(Integer.valueOf(3)::equals, null));
        Assert.assertEquals(Integer.valueOf(6), this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(6)::equals, function));
    }

    @Override
    @Test
    public void detectWithIfNoneBlock() {
        super.detectWithIfNoneBlock();
        Function0<Integer> function = new PassThruFunction0<>(-42);
        Assert.assertEquals(Integer.valueOf(5), this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 1, 2, 3, 4, 5).detectWithIfNone(Predicates2.greaterThan(), 4, function));
        Assert.assertEquals(Integer.valueOf(-42), this.newWith(Comparators.reverseNaturalOrder(), 1, 2, 2, 2, 3, 4, 5).detectWithIfNone(Predicates2.lessThan(), 0, function));
    }

    @Test
    public void corresponds() {
        Assert.assertFalse(this.newWith(1, 2, 3, 4, 5).corresponds(this.newWith(1, 2, 3, 4), Predicates2.alwaysTrue()));
        MutableSortedBag<Integer> integers1 = this.newWith(1, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        MutableSortedBag<Integer> integers2 = this.newWith(2, 3, 3, 4, 4, 4, 5, 5, 5, 5);
        Assert.assertTrue(integers1.corresponds(integers2, Predicates2.lessThan()));
        Assert.assertFalse(integers1.corresponds(integers2, Predicates2.greaterThan()));
        MutableSortedBag<Integer> integers3 = this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1);
        Assert.assertFalse(integers3.corresponds(integers1, Predicates2.equal()));
    }

    @Override
    @Test
    public void allSatisfy() {
        super.allSatisfy();
        MutableSortedBag<Integer> bag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertTrue(bag.allSatisfy(Predicates.lessThan(4)));
        Assert.assertFalse(bag.allSatisfy(Integer.valueOf(2)::equals));
        Assert.assertFalse(bag.allSatisfy(Predicates.greaterThan(4)));
    }

    @Override
    @Test
    public void allSatisfyWith() {
        super.allSatisfyWith();
        MutableSortedBag<Integer> bag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertTrue(bag.allSatisfyWith(Predicates2.lessThan(), 4));
        Assert.assertFalse(bag.allSatisfyWith(Object::equals, 2));
        Assert.assertFalse(bag.allSatisfyWith(Predicates2.greaterThan(), 4));
    }

    @Override
    @Test
    public void noneSatisfy() {
        super.noneSatisfy();
        MutableSortedBag<Integer> bag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertFalse(bag.noneSatisfy(Predicates.lessThan(4)));
        Assert.assertFalse(bag.noneSatisfy(Integer.valueOf(2)::equals));
        Assert.assertTrue(bag.noneSatisfy(Predicates.greaterThan(4)));
    }

    @Override
    @Test
    public void noneSatisfyWith() {
        super.noneSatisfyWith();
        MutableSortedBag<Integer> bag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertFalse(bag.noneSatisfyWith(Predicates2.lessThan(), 4));
        Assert.assertFalse(bag.noneSatisfyWith(Object::equals, 2));
        Assert.assertTrue(bag.noneSatisfyWith(Predicates2.greaterThan(), 4));
    }

    @Override
    @Test
    public void anySatisfy() {
        super.anySatisfy();
        MutableSortedBag<Integer> bag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertTrue(bag.anySatisfy(Predicates.lessThan(4)));
        Assert.assertTrue(bag.anySatisfy(Integer.valueOf(2)::equals));
        Assert.assertFalse(bag.anySatisfy(Predicates.greaterThan(4)));
    }

    @Override
    @Test
    public void anySatisfyWith() {
        super.anySatisfyWith();
        MutableSortedBag<Integer> bag = TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertTrue(bag.anySatisfyWith(Predicates2.lessThan(), 4));
        Assert.assertTrue(bag.anySatisfyWith(Object::equals, 2));
        Assert.assertFalse(bag.anySatisfyWith(Predicates2.greaterThan(), 4));
    }

    @Override
    @Test
    public void count() {
        super.count();
        MutableSortedBag<Integer> sortedBag = this.newWith(Collections.reverseOrder(), 3, 2, 2, 2, 1);
        Assert.assertEquals(1, sortedBag.count(Predicates.greaterThan(2)));
        Assert.assertEquals(4, sortedBag.count(Predicates.greaterThan(1)));
        Assert.assertEquals(0, sortedBag.count(Predicates.greaterThan(3)));
    }

    @Override
    @Test
    public void countWith() {
        super.countWith();
        MutableSortedBag<Integer> sortedBag = this.newWith(Collections.reverseOrder(), 3, 2, 2, 2, 1);
        Assert.assertEquals(1, sortedBag.countWith(Predicates2.greaterThan(), 2));
        Assert.assertEquals(4, sortedBag.countWith(Predicates2.greaterThan(), 1));
        Assert.assertEquals(0, sortedBag.countWith(Predicates2.greaterThan(), 3));
    }

    @Override
    @Test
    public void removeAllIterable() {
        super.removeAllIterable();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 5, 5, 3, 2, 2, 2, 1);
        Assert.assertTrue(bag.removeAllIterable(FastList.newListWith(1, 2, 4)));
        Assert.assertFalse(bag.removeAllIterable(FastList.newListWith(1, 2, 4)));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), 5, 5, 3), bag);
    }

    @Override
    @Test
    public void retainAll() {
        super.retainAll();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 5, 5, 3, 2, 1, 1, 1);
        Assert.assertTrue(bag.retainAll(FastList.newListWith(1, 2)));
        Assert.assertFalse(bag.retainAll(FastList.newListWith(1, 2)));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 2, 1, 1, 1), bag);
    }

    @Override
    @Test
    public void retainAllIterable() {
        super.retainAllIterable();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 5, 5, 3, 2, 1, 1, 1);
        Assert.assertTrue(bag.retainAllIterable(FastList.newListWith(1, 2)));
        Assert.assertFalse(bag.retainAllIterable(FastList.newListWith(1, 2)));
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 2, 1, 1, 1), bag);
    }

    @Override
    @Test
    public void injectInto() {
        super.injectInto();
        Assert.assertEquals(Integer.valueOf(11), this.newWith(Collections.reverseOrder(), 1, 1, 2, 3, 4).injectInto(Integer.valueOf(0), AddFunction.INTEGER));
    }

    @Override
    @Test
    public void injectIntoWith() {
        super.injectIntoWith();
        MutableSortedBag<Integer> bag = this.newWith(Collections.reverseOrder(), 1, 1, 2, 3);
        Integer result = bag.injectIntoWith(1, (injectedValued, item, parameter) -> injectedValued + item + parameter, 0);
        Assert.assertEquals(Integer.valueOf(8), result);
    }

    @Override
    @Test
    public void injectIntoInt() {
        super.injectIntoInt();
        Assert.assertEquals(11, this.newWith(Collections.reverseOrder(), 1, 1, 2, 3, 4).injectInto(0, AddFunction.INTEGER_TO_INT));
    }

    @Override
    @Test
    public void injectIntoLong() {
        super.injectIntoLong();
        Assert.assertEquals(8, this.newWith(Collections.reverseOrder(), 1, 1, 2, 3).injectInto(1L, AddFunction.INTEGER_TO_LONG));
    }

    @Override
    @Test
    public void injectIntoDouble() {
        super.injectIntoDouble();
        Assert.assertEquals(8.0, this.newWith(Collections.reverseOrder(), 1.0, 1.0, 2.0, 3.0).injectInto(1.0d, AddFunction.DOUBLE_TO_DOUBLE), 0.001);
    }

    @Override
    @Test
    public void injectIntoFloat() {
        super.injectIntoFloat();
        Assert.assertEquals(8.0, this.newWith(Collections.reverseOrder(), 1, 1, 2, 3).injectInto(1.0f, AddFunction.INTEGER_TO_FLOAT), 0.001);
    }

    @Override
    @Test
    public void sumFloat() {
        super.sumFloat();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4, 5);
        Assert.assertEquals(16.0f, bag.sumOfFloat(Integer::floatValue), 0.001);
    }

    @Override
    @Test
    public void sumDouble() {
        super.sumDouble();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4, 5);
        Assert.assertEquals(16.0d, bag.sumOfDouble(Integer::doubleValue), 0.001);
    }

    @Override
    @Test
    public void sumInteger() {
        super.sumInteger();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4, 5);
        Assert.assertEquals(16, bag.sumOfLong(Integer::longValue));
    }

    @Override
    @Test
    public void sumLong() {
        super.sumLong();
        MutableSortedBag<Integer> bag = this.newWith(Comparators.reverseNaturalOrder(), 1, 1, 2, 3, 4, 5);
        Assert.assertEquals(16, bag.sumOfLong(Integer::longValue));
    }

    @Override
    @Test
    public void toArray() {
        super.toArray();
        Assert.assertArrayEquals(new Object[] { 4, 4, 3, 2, 1 }, this.newWith(Collections.reverseOrder(), 4, 4, 3, 2, 1).toArray());
        Assert.assertArrayEquals(new Integer[] { 4, 4, 3, 2, 1 }, this.newWith(Collections.reverseOrder(), 4, 4, 3, 2, 1).toArray(new Integer[0]));
        Assert.assertArrayEquals(new Integer[] { 4, 4, 3, 2, 1, null, null }, this.newWith(Collections.reverseOrder(), 4, 4, 3, 2, 1).toArray(new Integer[7]));
    }

    @Override
    @Test
    public void chunk() {
        super.chunk();
        MutableSortedBag<String> bag = this.newWith(Comparators.reverseNaturalOrder(), "6", "5", "4", "3", "2", "1", "1");
        RichIterable<RichIterable<String>> groups = bag.chunk(2);
        Assert.assertEquals(FastList.newListWith(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "6", "5"), TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "4", "3"), TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "2", "1"), TreeBag.newBagWith(Comparators.reverseNaturalOrder(), "1")), groups);
    }

    @Override
    @Test
    public void aggregateByMutating() {
        super.aggregateByMutating();
        Function0<AtomicInteger> zeroValueFactory = AtomicInteger::new;
        MutableSortedBag<Integer> sortedBag = this.newWith(Comparators.reverseNaturalOrder(), 3, 2, 2, 1, 1, 1);
        MapIterable<String, AtomicInteger> aggregation = sortedBag.aggregateInPlaceBy(String::valueOf, zeroValueFactory, AtomicInteger::addAndGet);
        Assert.assertEquals(3, aggregation.get("1").intValue());
        Assert.assertEquals(4, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Override
    @Test
    public void aggregateByNonMutating() {
        super.aggregateByNonMutating();
        Function0<Integer> zeroValueFactory = () -> 0;
        Function2<Integer, Integer, Integer> sumAggregator = (integer1, integer2) -> integer1 + integer2;
        MutableSortedBag<Integer> sortedBag = this.newWith(Comparators.reverseNaturalOrder(), 3, 2, 2, 1, 1, 1);
        MapIterable<String, Integer> aggregation = sortedBag.aggregateBy(String::valueOf, zeroValueFactory, sumAggregator);
        Assert.assertEquals(3, aggregation.get("1").intValue());
        Assert.assertEquals(4, aggregation.get("2").intValue());
        Assert.assertEquals(3, aggregation.get("3").intValue());
    }

    @Override
    @Test
    public void toSortedBag_natural_ordering() {
        super.toSortedBag_natural_ordering();
        RichIterable<Integer> integers = this.newWith(Comparator.reverseOrder(), 2, 2, 2, 1, 1);
        MutableSortedBag<Integer> bag = integers.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 1, 2, 2, 2), bag);
    }

    @Override
    @Test
    public void toSortedBag_with_comparator() {
        super.toSortedList_with_comparator();
        RichIterable<Integer> integers = this.newWith(2, 4, 4, 1);
        MutableSortedBag<Integer> bag = integers.toSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 4, 2, 1), bag);
    }

    @Override
    @Test
    public void toSortedBagBy() {
        super.toSortedBagBy();
        RichIterable<Integer> integers = this.newWith(2, 2, 1, 1);
        MutableSortedBag<Integer> bag = integers.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 2, 1), bag);
    }

    @Override
    @Test
    public void topOccurrences() {
        // Sorted containers don't support null
        MutableSortedBag<String> strings = this.newWithOccurrences(PrimitiveTuples.pair("one", 1), PrimitiveTuples.pair("two", 2), PrimitiveTuples.pair("three", 3), PrimitiveTuples.pair("four", 4), PrimitiveTuples.pair("five", 5), PrimitiveTuples.pair("six", 6), PrimitiveTuples.pair("seven", 7), PrimitiveTuples.pair("eight", 8), PrimitiveTuples.pair("nine", 9), PrimitiveTuples.pair("ten", 10));
        MutableList<ObjectIntPair<String>> top5 = strings.topOccurrences(5);
        Verify.assertSize(5, top5);
        Assert.assertEquals("ten", top5.getFirst().getOne());
        Assert.assertEquals(10, top5.getFirst().getTwo());
        Assert.assertEquals("six", top5.getLast().getOne());
        Assert.assertEquals(6, top5.getLast().getTwo());
        Verify.assertSize(0, this.newWith().topOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(2));
        Verify.assertSize(3, this.newWith("one", "one", "two", "three").topOccurrences(2));
        Verify.assertSize(2, this.newWith("one", "one", "two", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "one", "two", "two", "three", "three").topOccurrences(1));
        Verify.assertSize(0, this.newWith().topOccurrences(0));
        Verify.assertSize(0, this.newWith("one").topOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().topOccurrences(-1));
    }

    @Override
    @Test
    public void bottomOccurrences() {
        // Sorted containers don't support null
        MutableSortedBag<String> strings = this.newWithOccurrences(PrimitiveTuples.pair("one", 1), PrimitiveTuples.pair("two", 2), PrimitiveTuples.pair("three", 3), PrimitiveTuples.pair("four", 4), PrimitiveTuples.pair("five", 5), PrimitiveTuples.pair("six", 6), PrimitiveTuples.pair("seven", 7), PrimitiveTuples.pair("eight", 8), PrimitiveTuples.pair("nine", 9), PrimitiveTuples.pair("ten", 10));
        MutableList<ObjectIntPair<String>> bottom5 = strings.bottomOccurrences(5);
        Verify.assertSize(5, bottom5);
        Assert.assertEquals("one", bottom5.getFirst().getOne());
        Assert.assertEquals(1, bottom5.getFirst().getTwo());
        Assert.assertEquals("five", bottom5.getLast().getOne());
        Assert.assertEquals(5, bottom5.getLast().getTwo());
        Verify.assertSize(0, this.newWith().bottomOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(5));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "two", "three").topOccurrences(2));
        Verify.assertSize(3, this.newWith("one", "one", "two", "three").topOccurrences(2));
        Verify.assertSize(2, this.newWith("one", "one", "two", "two", "three").topOccurrences(1));
        Verify.assertSize(3, this.newWith("one", "one", "two", "two", "three", "three").bottomOccurrences(1));
        Verify.assertSize(0, this.newWith().bottomOccurrences(0));
        Verify.assertSize(0, this.newWith("one").bottomOccurrences(0));
        Assert.assertThrows(IllegalArgumentException.class, () -> this.newWith().bottomOccurrences(-1));
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void min_null_safe() {
        super.min_null_safe();
    }

    @Override
    @Test(expected = NullPointerException.class)
    public void max_null_safe() {
        super.max_null_safe();
    }

    @Test
    public void detectIndex() {
        MutableSortedBag<Integer> integers1 = this.newWith(1, 1, 2, 2, 2, 3, 3, 3, 4, 4, 4, 4);
        Assert.assertEquals(2, integers1.detectIndex(integer -> integer % 2 == 0));
        Assert.assertEquals(5, integers1.detectIndex(integer -> integer % 3 == 0));
        Assert.assertEquals(0, integers1.detectIndex(integer -> integer % 2 != 0));
        Assert.assertEquals(-1, integers1.detectIndex(integer -> integer % 5 == 0));
        MutableSortedBag<Integer> integers2 = this.newWith(Comparators.reverseNaturalOrder(), 4, 4, 4, 4, 3, 3, 3, 2, 2, 1, 1);
        Assert.assertEquals(0, integers2.detectIndex(integer -> integer % 2 == 0));
        Assert.assertEquals(4, integers2.detectIndex(integer -> integer % 3 == 0));
        Assert.assertEquals(9, integers2.detectIndex(integer -> integer == 1));
        Assert.assertEquals(-1, integers2.detectIndex(integer -> integer % 5 == 0));
    }

    @Test
    public void take() {
        MutableSortedBag<Integer> integers1 = this.newWith(1, 1, 1, 2);
        Assert.assertEquals(SortedBags.mutable.empty(integers1.comparator()), integers1.take(0));
        Assert.assertSame(integers1.comparator(), integers1.take(0).comparator());
        Assert.assertEquals(this.newWith(integers1.comparator(), 1, 1, 1), integers1.take(3));
        Assert.assertSame(integers1.comparator(), integers1.take(3).comparator());
        Assert.assertEquals(this.newWith(integers1.comparator(), 1, 1, 1), integers1.take(integers1.size() - 1));
        MutableSortedBag<Integer> expectedBag = this.newWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
        MutableSortedBag<Integer> integers2 = this.newWith(Comparators.reverseNaturalOrder(), 3, 3, 3, 2, 2, 1);
        Assert.assertEquals(expectedBag, integers2.take(integers2.size()));
        Assert.assertEquals(expectedBag, integers2.take(10));
        Assert.assertEquals(expectedBag, integers2.take(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void take_throws() {
        this.newWith(1, 2, 3).take(-1);
    }

    @Test
    public void drop() {
        MutableSortedBag<Integer> integers1 = this.newWith(1, 1, 1, 2);
        Assert.assertEquals(integers1, integers1.drop(0));
        Assert.assertNotSame(integers1, integers1.drop(0));
        Assert.assertEquals(this.newWith(integers1.comparator(), 2), integers1.drop(3));
        Assert.assertEquals(this.newWith(integers1.comparator(), 2), integers1.drop(integers1.size() - 1));
        Assert.assertEquals(SortedBags.mutable.empty(integers1.comparator()), integers1.drop(integers1.size()));
        Assert.assertEquals(SortedBags.mutable.empty(integers1.comparator()), integers1.drop(10));
        Assert.assertEquals(SortedBags.mutable.empty(integers1.comparator()), integers1.drop(Integer.MAX_VALUE));
    }

    @Test(expected = IllegalArgumentException.class)
    public void drop_throws() {
        this.newWith(1, 2, 3).drop(-1);
    }

    @Override
    @Test
    public void selectUnique() {
        super.selectUnique();
        Comparator<Integer> comparator = Collections.reverseOrder();
        MutableSortedBag<Integer> integers = this.newWith(comparator, 5, 4, 3, 3, 2, 2, 2, 1, 1, 1, 1, 0);
        MutableSortedSet<Integer> expected = SortedSets.mutable.of(comparator, 5, 4, 0);
        MutableSortedSet<Integer> actual = integers.selectUnique();
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expected.comparator(), actual.comparator());
    }

    @Override
    @Test
    public void distinctView() {
        Comparator<String> comparator = Collections.reverseOrder();
        MutableBagIterable<String> bag = this.newWith(comparator, "1", "2", "2", "3", "3", "3", "3", "4", "5", "5", "6");
        RichIterable<String> expected = bag.toSortedSet(comparator);
        RichIterable<String> actual = bag.distinctView();
        // test content/type
        Assert.assertEquals(expected, actual);
        // test sorting
        Verify.assertIterablesEqual(expected, actual);
    }

    // Like Integer, but not Comparable
    public static final class Holder {

        private static final Function2<Integer, Integer, Holder> FROM_INT_INT = (each, each2) -> new Holder(each + each2);

        private static final Function<Integer, MutableList<Holder>> FROM_LIST = object -> FastList.newListWith(new Holder(object), new Holder(object));

        private static final IntFunction<Holder> TO_NUMBER = holder -> holder.number;

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

        private AbstractMutableSortedBagTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_contains() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.contains);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAnyCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAnyCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsNoneCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsNoneCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBooleanWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectBooleanWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByteWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectByteWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectCharWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectCharWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDoubleWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectDoubleWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloatWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectFloatWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIntWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIntWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLongWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectLongWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShortWithBagTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectShortWithBagTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectBoolean() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectBoolean);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectByte() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectByte);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectShort() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectShort);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectChar() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectChar);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectLong);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollectFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollectFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_empty_throws);
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
        public void benchmark_minOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxOptional);
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
        public void benchmark_minByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxByOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxByOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy_null_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy_null_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getAny() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getAny);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_not_only_one_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_not_only_one_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getOnly_empty_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.getOnly_empty_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeFloat() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeFloat);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloatConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumFloatConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeDouble() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeDouble);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding1() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding1);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDoubleConsistentRounding2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.sumDoubleConsistentRounding2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeInt() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeInt);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_summarizeLong() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.summarizeLong);
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
        public void benchmark_toImmutableList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toCollection() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toCollection);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy_with_null() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy_with_null);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapTarget() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapTarget);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutableBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutableBiMap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_fusedCollectMakeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.fusedCollectMakeString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringWithSeparatorAndStartAndEnd);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringThrows() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendStringThrows);
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
        public void benchmark_groupByUniqueKey() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByUniqueKey_target_throws_for_duplicate() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByUniqueKey_target_throws_for_duplicate);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_single() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk_single);
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
        public void benchmark_empty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.empty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.notEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reduceOptional() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.reduceOptional);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_newEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.newEmpty);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithWithWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithWithWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testNewWithVarArgs() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testNewWithVarArgs);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_clear() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.clear);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_with() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.with);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_without() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.without);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_withoutAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.withoutAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_largeCollectionStreamToBagMultimap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.largeCollectionStreamToBagMultimap);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asLazy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asLazy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iteratorRemove2() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iteratorRemove2);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_setOccurrences_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.setOccurrences_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_asSynchronized() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asSynchronized);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.anySatisfyWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.noneSatisfyWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.allSatisfyWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toImmutable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toImmutable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toString_with_collection_containing_self);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString_with_collection_containing_self);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString_with_collection_containing_self() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString_with_collection_containing_self);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testClone() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testClone);
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
        public void benchmark_removeObject() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeObject);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeIfWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeIfWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_equalsAndHashCode() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.equalsAndHashCode);
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
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectWith_target);
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
        public void benchmark_partitionWhile() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWhile);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectAndRejectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectAndRejectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinct() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinct);
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
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectIf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
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
        public void benchmark_zip() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zip);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.zipWithIndex);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStringOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStringOfItemToCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_add() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.add);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_throws);
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
        public void benchmark_forEachFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachFromTo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndexWithFromTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithIndexWithFromTo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.forEachWithOccurrences);
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
        public void benchmark_indexOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.indexOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_occurrencesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.occurrencesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_addOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.addOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_removeOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toStack() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toStack);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_asUnmodifiable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.asUnmodifiable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_serialization() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.serialization);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectByOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectByOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectDuplicates() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectDuplicates);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMapOfItemToCount() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMapOfItemToCount);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_compareTo() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.compareTo);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_minBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.minBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.maxBy);
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
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWithIfNoneBlock);
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
        public void benchmark_removeAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.removeAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAll() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAll);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_retainAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.retainAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectInto);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.injectIntoWith);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_topOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.topOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_bottomOccurrences() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.bottomOccurrences);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.min_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_null_safe() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.max_null_safe);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIndex() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectIndex);
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
        public void benchmark_selectUnique() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectUnique);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_distinctView() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.distinctView);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractMutableSortedBagTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> reduceOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> newEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> testNewWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> testNewWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> testNewWithWithWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> testNewWithVarArgs;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> removeAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> clear;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> with;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> withAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> without;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> withoutAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> largeCollectionStreamToBagMultimap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> asLazy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> iteratorRemove;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> iteratorRemove2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> addOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> removeOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> setOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> setOccurrences_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedListWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> asSynchronized;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> anySatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> noneSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> allSatisfyWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> detectWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toImmutable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> makeString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> appendString_with_collection_containing_self;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> addAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> addAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> testClone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> removeObject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> removeIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> removeIfWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> partitionWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> selectAndRejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectWithIndexWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> distinct;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> takeWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> dropWhile;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toStringOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> add;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> forEachFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> forEachWithIndexWithFromTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> forEachWithOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> indexOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> occurrencesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> addOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> removeOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toStack;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> asUnmodifiable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> serialization;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> selectByOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> selectDuplicates;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toMapOfItemToCount;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> compareTo;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> corresponds;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> removeAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> retainAll;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> retainAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> injectIntoWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> topOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> bottomOccurrences;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> detectIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> take;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> take_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> drop;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> drop_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> selectUnique;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractMutableSortedBagTestCase> distinctView;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = AbstractMutableSortedBagTestCase::testNewCollection;
            this.payloads.contains = AbstractMutableSortedBagTestCase::contains;
            this.payloads.containsBy = AbstractMutableSortedBagTestCase::containsBy;
            this.payloads.containsAnyIterable = AbstractMutableSortedBagTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = AbstractMutableSortedBagTestCase::containsNoneIterable;
            this.payloads.containsAnyCollection = AbstractMutableSortedBagTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = AbstractMutableSortedBagTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = AbstractMutableSortedBagTestCase::containsAllCollection;
            this.payloads.selectInstancesOf = AbstractMutableSortedBagTestCase::selectInstancesOf;
            this.payloads.collectTarget = AbstractMutableSortedBagTestCase::collectTarget;
            this.payloads.collectBooleanWithTarget = AbstractMutableSortedBagTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = AbstractMutableSortedBagTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByteWithTarget = AbstractMutableSortedBagTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = AbstractMutableSortedBagTestCase::collectByteWithBagTarget;
            this.payloads.collectCharWithTarget = AbstractMutableSortedBagTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = AbstractMutableSortedBagTestCase::collectCharWithBagTarget;
            this.payloads.collectDoubleWithTarget = AbstractMutableSortedBagTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = AbstractMutableSortedBagTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloatWithTarget = AbstractMutableSortedBagTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = AbstractMutableSortedBagTestCase::collectFloatWithBagTarget;
            this.payloads.collectIntWithTarget = AbstractMutableSortedBagTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = AbstractMutableSortedBagTestCase::collectIntWithBagTarget;
            this.payloads.collectLongWithTarget = AbstractMutableSortedBagTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = AbstractMutableSortedBagTestCase::collectLongWithBagTarget;
            this.payloads.collectShortWithTarget = AbstractMutableSortedBagTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = AbstractMutableSortedBagTestCase::collectShortWithBagTarget;
            this.payloads.flatCollectWith = AbstractMutableSortedBagTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = AbstractMutableSortedBagTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = AbstractMutableSortedBagTestCase::flatCollectByte;
            this.payloads.flatCollectShort = AbstractMutableSortedBagTestCase::flatCollectShort;
            this.payloads.flatCollectInt = AbstractMutableSortedBagTestCase::flatCollectInt;
            this.payloads.flatCollectChar = AbstractMutableSortedBagTestCase::flatCollectChar;
            this.payloads.flatCollectLong = AbstractMutableSortedBagTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = AbstractMutableSortedBagTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = AbstractMutableSortedBagTestCase::flatCollectFloat;
            this.payloads.detectOptional = AbstractMutableSortedBagTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.minOptional = AbstractMutableSortedBagTestCase::minOptional;
            this.payloads.maxOptional = AbstractMutableSortedBagTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractMutableSortedBagTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractMutableSortedBagTestCase::max_without_comparator;
            this.payloads.minByOptional = AbstractMutableSortedBagTestCase::minByOptional;
            this.payloads.maxByOptional = AbstractMutableSortedBagTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWithOptional = AbstractMutableSortedBagTestCase::detectWithOptional;
            this.payloads.getAny = AbstractMutableSortedBagTestCase::getAny;
            this.payloads.getOnly = AbstractMutableSortedBagTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractMutableSortedBagTestCase::isEmpty;
            this.payloads.summarizeFloat = AbstractMutableSortedBagTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = AbstractMutableSortedBagTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = AbstractMutableSortedBagTestCase::sumFloatConsistentRounding2;
            this.payloads.summarizeDouble = AbstractMutableSortedBagTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = AbstractMutableSortedBagTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = AbstractMutableSortedBagTestCase::sumDoubleConsistentRounding2;
            this.payloads.summarizeInt = AbstractMutableSortedBagTestCase::summarizeInt;
            this.payloads.summarizeLong = AbstractMutableSortedBagTestCase::summarizeLong;
            this.payloads.sumByInt = AbstractMutableSortedBagTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractMutableSortedBagTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractMutableSortedBagTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractMutableSortedBagTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractMutableSortedBagTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractMutableSortedBagTestCase::sumByDoubleConsistentRounding;
            this.payloads.toImmutableList = AbstractMutableSortedBagTestCase::toImmutableList;
            this.payloads.toCollection = AbstractMutableSortedBagTestCase::toCollection;
            this.payloads.toImmutableBag = AbstractMutableSortedBagTestCase::toImmutableBag;
            this.payloads.toImmutableSortedList_natural_ordering = AbstractMutableSortedBagTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_with_comparator = AbstractMutableSortedBagTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBag_natural_ordering = AbstractMutableSortedBagTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_with_comparator = AbstractMutableSortedBagTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSortedBagBy = AbstractMutableSortedBagTestCase::toImmutableSortedBagBy;
            this.payloads.toImmutableSortedListBy = AbstractMutableSortedBagTestCase::toImmutableSortedListBy;
            this.payloads.toImmutableSortSet_natural_ordering = AbstractMutableSortedBagTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toImmutableSortedSet_with_comparator = AbstractMutableSortedBagTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toImmutableSortedSetBy = AbstractMutableSortedBagTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toImmutableSet = AbstractMutableSortedBagTestCase::toImmutableSet;
            this.payloads.toImmutableMap = AbstractMutableSortedBagTestCase::toImmutableMap;
            this.payloads.toMapTarget = AbstractMutableSortedBagTestCase::toMapTarget;
            this.payloads.toBiMap = AbstractMutableSortedBagTestCase::toBiMap;
            this.payloads.toImmutableBiMap = AbstractMutableSortedBagTestCase::toImmutableBiMap;
            this.payloads.makeStringWithSeparator = AbstractMutableSortedBagTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractMutableSortedBagTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = AbstractMutableSortedBagTestCase::fusedCollectMakeString;
            this.payloads.appendStringWithSeparator = AbstractMutableSortedBagTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractMutableSortedBagTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = AbstractMutableSortedBagTestCase::appendStringThrows;
            this.payloads.countBy = AbstractMutableSortedBagTestCase::countBy;
            this.payloads.countByWith = AbstractMutableSortedBagTestCase::countByWith;
            this.payloads.countByEach = AbstractMutableSortedBagTestCase::countByEach;
            this.payloads.groupByUniqueKey = AbstractMutableSortedBagTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractMutableSortedBagTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.chunk_empty = AbstractMutableSortedBagTestCase::chunk_empty;
            this.payloads.chunk_single = AbstractMutableSortedBagTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractMutableSortedBagTestCase::chunk_large_size;
            this.payloads.empty = AbstractMutableSortedBagTestCase::empty;
            this.payloads.notEmpty = AbstractMutableSortedBagTestCase::notEmpty;
            this.payloads.reduceOptional = AbstractMutableSortedBagTestCase::reduceOptional;
            this.payloads.newEmpty = AbstractMutableSortedBagTestCase::newEmpty;
            this.payloads.testNewWith = AbstractMutableSortedBagTestCase::testNewWith;
            this.payloads.testNewWithWith = AbstractMutableSortedBagTestCase::testNewWithWith;
            this.payloads.testNewWithWithWith = AbstractMutableSortedBagTestCase::testNewWithWithWith;
            this.payloads.testNewWithVarArgs = AbstractMutableSortedBagTestCase::testNewWithVarArgs;
            this.payloads.removeAll = AbstractMutableSortedBagTestCase::removeAll;
            this.payloads.clear = AbstractMutableSortedBagTestCase::clear;
            this.payloads.with = AbstractMutableSortedBagTestCase::with;
            this.payloads.withAll = AbstractMutableSortedBagTestCase::withAll;
            this.payloads.without = AbstractMutableSortedBagTestCase::without;
            this.payloads.withoutAll = AbstractMutableSortedBagTestCase::withoutAll;
            this.payloads.largeCollectionStreamToBagMultimap = AbstractMutableSortedBagTestCase::largeCollectionStreamToBagMultimap;
            this.payloads.asLazy = AbstractMutableSortedBagTestCase::asLazy;
            this.payloads.iteratorRemove = AbstractMutableSortedBagTestCase::iteratorRemove;
            this.payloads.iteratorRemove2 = AbstractMutableSortedBagTestCase::iteratorRemove2;
            this.payloads.collectWithOccurrences = AbstractMutableSortedBagTestCase::collectWithOccurrences;
            this.payloads.addOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::addOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.removeOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::removeOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.setOccurrences = AbstractMutableSortedBagTestCase::setOccurrences;
            this.payloads.setOccurrences_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::setOccurrences_throws, java.lang.IllegalArgumentException.class);
            this.payloads.toSortedListWith = AbstractMutableSortedBagTestCase::toSortedListWith;
            this.payloads.asSynchronized = AbstractMutableSortedBagTestCase::asSynchronized;
            this.payloads.anySatisfyWithOccurrences = AbstractMutableSortedBagTestCase::anySatisfyWithOccurrences;
            this.payloads.noneSatisfyWithOccurrences = AbstractMutableSortedBagTestCase::noneSatisfyWithOccurrences;
            this.payloads.allSatisfyWithOccurrences = AbstractMutableSortedBagTestCase::allSatisfyWithOccurrences;
            this.payloads.detectWithOccurrences = AbstractMutableSortedBagTestCase::detectWithOccurrences;
            this.payloads.toImmutable = AbstractMutableSortedBagTestCase::toImmutable;
            this.payloads.toString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::toString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.makeString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::makeString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.appendString_with_collection_containing_self = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::appendString_with_collection_containing_self, java.lang.ClassCastException.class);
            this.payloads.addAll = AbstractMutableSortedBagTestCase::addAll;
            this.payloads.addAllIterable = AbstractMutableSortedBagTestCase::addAllIterable;
            this.payloads.testClone = AbstractMutableSortedBagTestCase::testClone;
            this.payloads.testToString = AbstractMutableSortedBagTestCase::testToString;
            this.payloads.makeString = AbstractMutableSortedBagTestCase::makeString;
            this.payloads.appendString = AbstractMutableSortedBagTestCase::appendString;
            this.payloads.removeObject = AbstractMutableSortedBagTestCase::removeObject;
            this.payloads.removeIf = AbstractMutableSortedBagTestCase::removeIf;
            this.payloads.removeIfWith = AbstractMutableSortedBagTestCase::removeIfWith;
            this.payloads.equalsAndHashCode = AbstractMutableSortedBagTestCase::equalsAndHashCode;
            this.payloads.select = AbstractMutableSortedBagTestCase::select;
            this.payloads.selectWith = AbstractMutableSortedBagTestCase::selectWith;
            this.payloads.selectWith_target = AbstractMutableSortedBagTestCase::selectWith_target;
            this.payloads.reject = AbstractMutableSortedBagTestCase::reject;
            this.payloads.rejectWith = AbstractMutableSortedBagTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractMutableSortedBagTestCase::rejectWith_target;
            this.payloads.partition = AbstractMutableSortedBagTestCase::partition;
            this.payloads.partitionWith = AbstractMutableSortedBagTestCase::partitionWith;
            this.payloads.partitionWhile = AbstractMutableSortedBagTestCase::partitionWhile;
            this.payloads.selectAndRejectWith = AbstractMutableSortedBagTestCase::selectAndRejectWith;
            this.payloads.collect = AbstractMutableSortedBagTestCase::collect;
            this.payloads.collectWithIndex = AbstractMutableSortedBagTestCase::collectWithIndex;
            this.payloads.collectWithIndexWithTarget = AbstractMutableSortedBagTestCase::collectWithIndexWithTarget;
            this.payloads.flatCollect = AbstractMutableSortedBagTestCase::flatCollect;
            this.payloads.distinct = AbstractMutableSortedBagTestCase::distinct;
            this.payloads.takeWhile = AbstractMutableSortedBagTestCase::takeWhile;
            this.payloads.dropWhile = AbstractMutableSortedBagTestCase::dropWhile;
            this.payloads.collectIf = AbstractMutableSortedBagTestCase::collectIf;
            this.payloads.collectWith = AbstractMutableSortedBagTestCase::collectWith;
            this.payloads.collectWith_target = AbstractMutableSortedBagTestCase::collectWith_target;
            this.payloads.groupBy = AbstractMutableSortedBagTestCase::groupBy;
            this.payloads.groupByEach = AbstractMutableSortedBagTestCase::groupByEach;
            this.payloads.zip = AbstractMutableSortedBagTestCase::zip;
            this.payloads.zipWithIndex = AbstractMutableSortedBagTestCase::zipWithIndex;
            this.payloads.toStringOfItemToCount = AbstractMutableSortedBagTestCase::toStringOfItemToCount;
            this.payloads.add = AbstractMutableSortedBagTestCase::add;
            this.payloads.iterator = AbstractMutableSortedBagTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.tap = AbstractMutableSortedBagTestCase::tap;
            this.payloads.forEach = AbstractMutableSortedBagTestCase::forEach;
            this.payloads.forEachFromTo = AbstractMutableSortedBagTestCase::forEachFromTo;
            this.payloads.forEachWithIndexWithFromTo = AbstractMutableSortedBagTestCase::forEachWithIndexWithFromTo;
            this.payloads.forEachWithOccurrences = AbstractMutableSortedBagTestCase::forEachWithOccurrences;
            this.payloads.getFirst = AbstractMutableSortedBagTestCase::getFirst;
            this.payloads.getLast = AbstractMutableSortedBagTestCase::getLast;
            this.payloads.indexOf = AbstractMutableSortedBagTestCase::indexOf;
            this.payloads.occurrencesOf = AbstractMutableSortedBagTestCase::occurrencesOf;
            this.payloads.addOccurrences = AbstractMutableSortedBagTestCase::addOccurrences;
            this.payloads.removeOccurrences = AbstractMutableSortedBagTestCase::removeOccurrences;
            this.payloads.toList = AbstractMutableSortedBagTestCase::toList;
            this.payloads.toSet = AbstractMutableSortedBagTestCase::toSet;
            this.payloads.toBag = AbstractMutableSortedBagTestCase::toBag;
            this.payloads.toStack = AbstractMutableSortedBagTestCase::toStack;
            this.payloads.toSortedList_natural_ordering = AbstractMutableSortedBagTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractMutableSortedBagTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractMutableSortedBagTestCase::toSortedListBy;
            this.payloads.toSortedSet_natural_ordering = AbstractMutableSortedBagTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractMutableSortedBagTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractMutableSortedBagTestCase::toSortedSetBy;
            this.payloads.toMap = AbstractMutableSortedBagTestCase::toMap;
            this.payloads.toSortedMap = AbstractMutableSortedBagTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractMutableSortedBagTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractMutableSortedBagTestCase::toSortedMapBy;
            this.payloads.asUnmodifiable = AbstractMutableSortedBagTestCase::asUnmodifiable;
            this.payloads.serialization = AbstractMutableSortedBagTestCase::serialization;
            this.payloads.selectByOccurrences = AbstractMutableSortedBagTestCase::selectByOccurrences;
            this.payloads.selectDuplicates = AbstractMutableSortedBagTestCase::selectDuplicates;
            this.payloads.toMapOfItemToCount = AbstractMutableSortedBagTestCase::toMapOfItemToCount;
            this.payloads.compareTo = AbstractMutableSortedBagTestCase::compareTo;
            this.payloads.containsAllIterable = AbstractMutableSortedBagTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractMutableSortedBagTestCase::containsAllArray;
            this.payloads.forEachWith = AbstractMutableSortedBagTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractMutableSortedBagTestCase::forEachWithIndex;
            this.payloads.collectBoolean = AbstractMutableSortedBagTestCase::collectBoolean;
            this.payloads.collectByte = AbstractMutableSortedBagTestCase::collectByte;
            this.payloads.collectChar = AbstractMutableSortedBagTestCase::collectChar;
            this.payloads.collectDouble = AbstractMutableSortedBagTestCase::collectDouble;
            this.payloads.collectFloat = AbstractMutableSortedBagTestCase::collectFloat;
            this.payloads.collectInt = AbstractMutableSortedBagTestCase::collectInt;
            this.payloads.collectLong = AbstractMutableSortedBagTestCase::collectLong;
            this.payloads.collectShort = AbstractMutableSortedBagTestCase::collectShort;
            this.payloads.detect = AbstractMutableSortedBagTestCase::detect;
            this.payloads.min = AbstractMutableSortedBagTestCase::min;
            this.payloads.max = AbstractMutableSortedBagTestCase::max;
            this.payloads.minBy = AbstractMutableSortedBagTestCase::minBy;
            this.payloads.maxBy = AbstractMutableSortedBagTestCase::maxBy;
            this.payloads.detectWith = AbstractMutableSortedBagTestCase::detectWith;
            this.payloads.detectIfNone = AbstractMutableSortedBagTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractMutableSortedBagTestCase::detectWithIfNoneBlock;
            this.payloads.corresponds = AbstractMutableSortedBagTestCase::corresponds;
            this.payloads.allSatisfy = AbstractMutableSortedBagTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractMutableSortedBagTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractMutableSortedBagTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractMutableSortedBagTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractMutableSortedBagTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractMutableSortedBagTestCase::anySatisfyWith;
            this.payloads.count = AbstractMutableSortedBagTestCase::count;
            this.payloads.countWith = AbstractMutableSortedBagTestCase::countWith;
            this.payloads.removeAllIterable = AbstractMutableSortedBagTestCase::removeAllIterable;
            this.payloads.retainAll = AbstractMutableSortedBagTestCase::retainAll;
            this.payloads.retainAllIterable = AbstractMutableSortedBagTestCase::retainAllIterable;
            this.payloads.injectInto = AbstractMutableSortedBagTestCase::injectInto;
            this.payloads.injectIntoWith = AbstractMutableSortedBagTestCase::injectIntoWith;
            this.payloads.injectIntoInt = AbstractMutableSortedBagTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractMutableSortedBagTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractMutableSortedBagTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractMutableSortedBagTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractMutableSortedBagTestCase::sumFloat;
            this.payloads.sumDouble = AbstractMutableSortedBagTestCase::sumDouble;
            this.payloads.sumInteger = AbstractMutableSortedBagTestCase::sumInteger;
            this.payloads.sumLong = AbstractMutableSortedBagTestCase::sumLong;
            this.payloads.toArray = AbstractMutableSortedBagTestCase::toArray;
            this.payloads.chunk = AbstractMutableSortedBagTestCase::chunk;
            this.payloads.aggregateByMutating = AbstractMutableSortedBagTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractMutableSortedBagTestCase::aggregateByNonMutating;
            this.payloads.toSortedBag_natural_ordering = AbstractMutableSortedBagTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractMutableSortedBagTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractMutableSortedBagTestCase::toSortedBagBy;
            this.payloads.topOccurrences = AbstractMutableSortedBagTestCase::topOccurrences;
            this.payloads.bottomOccurrences = AbstractMutableSortedBagTestCase::bottomOccurrences;
            this.payloads.min_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::min_null_safe, java.lang.NullPointerException.class);
            this.payloads.max_null_safe = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::max_null_safe, java.lang.NullPointerException.class);
            this.payloads.detectIndex = AbstractMutableSortedBagTestCase::detectIndex;
            this.payloads.take = AbstractMutableSortedBagTestCase::take;
            this.payloads.take_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::take_throws, java.lang.IllegalArgumentException.class);
            this.payloads.drop = AbstractMutableSortedBagTestCase::drop;
            this.payloads.drop_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractMutableSortedBagTestCase::drop_throws, java.lang.IllegalArgumentException.class);
            this.payloads.selectUnique = AbstractMutableSortedBagTestCase::selectUnique;
            this.payloads.distinctView = AbstractMutableSortedBagTestCase::distinctView;
        }
    }
}
