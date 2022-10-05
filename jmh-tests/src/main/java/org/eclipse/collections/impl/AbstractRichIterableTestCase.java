/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.DoubleSummaryStatistics;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.bag.Bag;
import org.eclipse.collections.api.bag.ImmutableBag;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.bag.primitive.BooleanBag;
import org.eclipse.collections.api.bag.primitive.ByteBag;
import org.eclipse.collections.api.bag.primitive.CharBag;
import org.eclipse.collections.api.bag.primitive.DoubleBag;
import org.eclipse.collections.api.bag.primitive.FloatBag;
import org.eclipse.collections.api.bag.primitive.IntBag;
import org.eclipse.collections.api.bag.primitive.LongBag;
import org.eclipse.collections.api.bag.primitive.MutableBooleanBag;
import org.eclipse.collections.api.bag.primitive.MutableByteBag;
import org.eclipse.collections.api.bag.primitive.MutableCharBag;
import org.eclipse.collections.api.bag.primitive.MutableDoubleBag;
import org.eclipse.collections.api.bag.primitive.MutableFloatBag;
import org.eclipse.collections.api.bag.primitive.MutableIntBag;
import org.eclipse.collections.api.bag.primitive.MutableLongBag;
import org.eclipse.collections.api.bag.primitive.MutableShortBag;
import org.eclipse.collections.api.bag.primitive.ShortBag;
import org.eclipse.collections.api.bag.sorted.ImmutableSortedBag;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.procedure.Procedure;
import org.eclipse.collections.api.collection.primitive.MutableBooleanCollection;
import org.eclipse.collections.api.collection.primitive.MutableByteCollection;
import org.eclipse.collections.api.collection.primitive.MutableCharCollection;
import org.eclipse.collections.api.collection.primitive.MutableDoubleCollection;
import org.eclipse.collections.api.collection.primitive.MutableFloatCollection;
import org.eclipse.collections.api.collection.primitive.MutableIntCollection;
import org.eclipse.collections.api.collection.primitive.MutableLongCollection;
import org.eclipse.collections.api.collection.primitive.MutableShortCollection;
import org.eclipse.collections.api.factory.Maps;
import org.eclipse.collections.api.factory.SortedBags;
import org.eclipse.collections.api.list.ImmutableList;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.ImmutableMap;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.ObjectDoubleMap;
import org.eclipse.collections.api.map.primitive.ObjectLongMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.multimap.MutableMultimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.ImmutableSet;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.primitive.MutableBooleanSet;
import org.eclipse.collections.api.set.primitive.MutableByteSet;
import org.eclipse.collections.api.set.primitive.MutableCharSet;
import org.eclipse.collections.api.set.primitive.MutableDoubleSet;
import org.eclipse.collections.api.set.primitive.MutableFloatSet;
import org.eclipse.collections.api.set.primitive.MutableIntSet;
import org.eclipse.collections.api.set.primitive.MutableLongSet;
import org.eclipse.collections.api.set.primitive.MutableShortSet;
import org.eclipse.collections.api.set.sorted.ImmutableSortedSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.BooleanBooleanPair;
import org.eclipse.collections.api.tuple.primitive.ByteBytePair;
import org.eclipse.collections.api.tuple.primitive.CharCharPair;
import org.eclipse.collections.api.tuple.primitive.DoubleDoublePair;
import org.eclipse.collections.api.tuple.primitive.FloatFloatPair;
import org.eclipse.collections.api.tuple.primitive.IntIntPair;
import org.eclipse.collections.api.tuple.primitive.LongLongPair;
import org.eclipse.collections.api.tuple.primitive.ShortShortPair;
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
import org.eclipse.collections.impl.block.function.AddFunction;
import org.eclipse.collections.impl.block.function.NegativeIntervalFunction;
import org.eclipse.collections.impl.block.function.PassThruFunction0;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.factory.Sets;
import org.eclipse.collections.impl.factory.SortedSets;
import org.eclipse.collections.impl.factory.primitive.BooleanBags;
import org.eclipse.collections.impl.factory.primitive.BooleanLists;
import org.eclipse.collections.impl.factory.primitive.ByteBags;
import org.eclipse.collections.impl.factory.primitive.ByteLists;
import org.eclipse.collections.impl.factory.primitive.CharBags;
import org.eclipse.collections.impl.factory.primitive.CharLists;
import org.eclipse.collections.impl.factory.primitive.DoubleBags;
import org.eclipse.collections.impl.factory.primitive.DoubleSets;
import org.eclipse.collections.impl.factory.primitive.FloatBags;
import org.eclipse.collections.impl.factory.primitive.FloatLists;
import org.eclipse.collections.impl.factory.primitive.IntBags;
import org.eclipse.collections.impl.factory.primitive.IntLists;
import org.eclipse.collections.impl.factory.primitive.LongBags;
import org.eclipse.collections.impl.factory.primitive.LongLists;
import org.eclipse.collections.impl.factory.primitive.ShortBags;
import org.eclipse.collections.impl.factory.primitive.ShortLists;
import org.eclipse.collections.impl.list.Interval;
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
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.mutable.primitive.BooleanHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ByteHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.CharHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.DoubleHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.FloatHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.IntHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.LongHashSet;
import org.eclipse.collections.impl.set.mutable.primitive.ShortHashSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

public abstract class AbstractRichIterableTestCase {

    protected abstract <T> RichIterable<T> newWith(T... littleElements);

    @Test
    public void testNewCollection() {
        RichIterable<Object> collection = this.newWith();
        Verify.assertIterableEmpty(collection);
        Verify.assertIterableSize(0, collection);
    }

    @Test
    public void equalsAndHashCode() {
        Verify.assertEqualsAndHashCode(this.newWith(1, 2, 3), this.newWith(1, 2, 3));
        Assert.assertNotEquals(this.newWith(1, 2, 3), this.newWith(1, 2));
    }

    @Test
    public void contains() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.contains(1));
        Assert.assertTrue(collection.contains(4));
        Assert.assertFalse(collection.contains(5));
    }

    @Test
    public void containsBy() {
        MutableList<Pair<Integer, String>> list = Lists.mutable.with(Tuples.pair(1, "1"), Tuples.pair(2, "2"), Tuples.pair(3, null));
        Assert.assertTrue(list.containsBy(Pair::getTwo, "2"));
        Assert.assertFalse(list.containsBy(Pair::getTwo, "3"));
        Assert.assertTrue(list.containsBy(Pair::getTwo, null));
        Assert.assertFalse(list.containsBy(Pair::getOne, null));
        Assert.assertFalse(list.newEmpty().containsBy(Pair::getOne, null));
        Assert.assertFalse(list.newEmpty().containsBy(Pair::getOne, "2"));
        Assert.assertThrows(NullPointerException.class, () -> list.newEmpty().containsBy(null, "2"));
    }

    @Test
    public void containsAllIterable() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsAllIterable(Lists.mutable.with(1, 2)));
        Assert.assertFalse(collection.containsAllIterable(Lists.mutable.with(1, 5)));
    }

    @Test
    public void containsAnyIterable() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsAnyIterable(Lists.mutable.with(0, 1)));
        Assert.assertTrue(collection.containsAnyIterable(Arrays.asList(0, 1)));
        Assert.assertFalse(collection.containsAnyIterable(Lists.mutable.with(5, 6)));
        Assert.assertFalse(collection.containsAnyIterable(Arrays.asList(5, 6)));
        Assert.assertTrue(collection.containsAnyIterable(Interval.oneTo(100)));
        Assert.assertFalse(collection.containsAnyIterable(Interval.fromTo(5, 100)));
        Assert.assertTrue(Interval.oneTo(100).containsAnyIterable(collection));
        Assert.assertFalse(Interval.fromTo(5, 100).containsAnyIterable(collection));
        Assert.assertTrue(this.newWith(Interval.oneTo(100).toArray()).containsAnyIterable(Interval.oneTo(50)));
        Assert.assertFalse(this.newWith(Interval.fromTo(5, 100).toArray()).containsAnyIterable(Interval.fromTo(200, 250)));
    }

    @Test
    public void containsNoneIterable() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsNoneIterable(Lists.mutable.with(0, 5, 6, 7)));
        Assert.assertTrue(collection.containsNoneIterable(Arrays.asList(0, 5, 6, 7)));
        Assert.assertFalse(collection.containsNoneIterable(Lists.mutable.with(0, 1, 5, 6)));
        Assert.assertFalse(collection.containsNoneIterable(Arrays.asList(0, 1, 5, 6)));
        Assert.assertFalse(collection.containsNoneIterable(Interval.oneTo(100)));
        Assert.assertTrue(collection.containsNoneIterable(Interval.fromTo(5, 100)));
        Assert.assertFalse(Interval.oneTo(100).containsNoneIterable(collection));
        Assert.assertTrue(Interval.fromTo(5, 100).containsNoneIterable(collection));
        Assert.assertFalse(this.newWith(Interval.oneTo(100).toArray()).containsNoneIterable(Interval.oneTo(50)));
        Assert.assertTrue(this.newWith(Interval.fromTo(5, 100).toArray()).containsNoneIterable(Interval.fromTo(200, 250)));
    }

    @Test
    public void containsAllArray() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsAllArguments(1, 2));
        Assert.assertFalse(collection.containsAllArguments(1, 5));
    }

    @Test
    public void containsAnyCollection() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsAny(Lists.mutable.with(0, 1)));
        Assert.assertTrue(collection.containsAny(Arrays.asList(0, 1)));
        Assert.assertFalse(collection.containsAny(Lists.mutable.with(5, 6)));
        Assert.assertFalse(collection.containsAny(Arrays.asList(5, 6)));
        Assert.assertTrue(collection.containsAny(Interval.oneTo(100)));
        Assert.assertFalse(collection.containsAny(Interval.fromTo(5, 100)));
        Assert.assertTrue(this.newWith(Interval.oneTo(100).toArray()).containsAny(Interval.oneTo(50)));
        Assert.assertFalse(this.newWith(Interval.fromTo(5, 100).toArray()).containsAny(Interval.fromTo(200, 250)));
    }

    @Test
    public void containsNoneCollection() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsNone(Lists.mutable.with(0, 5, 6, 7)));
        Assert.assertTrue(collection.containsNone(Arrays.asList(0, 5, 6, 7)));
        Assert.assertFalse(collection.containsNone(Lists.mutable.with(0, 1, 5, 6)));
        Assert.assertFalse(collection.containsNone(Arrays.asList(0, 1, 5, 6)));
        Assert.assertFalse(collection.containsNone(Interval.oneTo(100)));
        Assert.assertTrue(collection.containsNone(Interval.fromTo(5, 100)));
        Assert.assertFalse(this.newWith(Interval.oneTo(100).toArray()).containsNone(Interval.oneTo(50)));
        Assert.assertTrue(this.newWith(Interval.fromTo(5, 100).toArray()).containsNone(Interval.fromTo(200, 250)));
    }

    @Test
    public void containsAllCollection() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertTrue(collection.containsAll(Lists.mutable.with(1, 2)));
        Assert.assertFalse(collection.containsAll(Lists.mutable.with(1, 5)));
    }

    @Test
    public void tap() {
        MutableList<Integer> tapResult = Lists.mutable.of();
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Assert.assertSame(collection, collection.tap(tapResult::add));
        Assert.assertEquals(collection.toList(), tapResult);
    }

    private void forEach(Function<Collection<Integer>, Consumer<Integer>> adderProvider) {
        MutableList<Integer> result = Lists.mutable.of();
        RichIterable<Integer> template = this.newWith(1, 2, 3, 4);
        Consumer<Integer> adder = adderProvider.apply(result);
        if (adder instanceof Procedure<?>) {
            template.forEach((Procedure<Integer>) adder);
        } else {
            template.forEach(adder);
        }
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, 1, 2, 3, 4);
    }

    private void forEachProcedure() {
        this.forEach(CollectionAddProcedure::on);
    }

    private void forEachConsumer() {
        this.forEach(collection -> collection::add);
    }

    @Test
    public void forEach() {
        this.forEachProcedure();
        this.forEachConsumer();
    }

    @Test
    public void forEachWith() {
        MutableList<Integer> result = Lists.mutable.of();
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.forEachWith((argument1, argument2) -> result.add(argument1 + argument2), 0);
        Verify.assertSize(4, result);
        Verify.assertContainsAll(result, 1, 2, 3, 4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<Integer> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        collection.forEachWithIndex((object, index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(1, 2, 3, 4), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2, 3), indexes);
    }

    @Test
    public void select() {
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4, 5).select(Predicates.lessThan(3)), 1, 2);
        RichIterable<Integer> result = this.newWith(-1, 2, 3, 4, 5).select(Predicates.lessThan(3));
        Verify.assertNotContains(3, result);
        Verify.assertNotContains(4, result);
        Verify.assertNotContains(5, result);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4, 5).select(Predicates.lessThan(3), UnifiedSet.newSet()), 1, 2);
    }

    @Test
    public void selectWith() {
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3), 1, 2);
        RichIterable<Integer> result = this.newWith(-1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3);
        Verify.assertNotContains(3, result);
        Verify.assertNotContains(4, result);
        Verify.assertNotContains(5, result);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3), 1, 2);
    }

    @Test
    public void selectWith_target() {
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3, HashBag.newBag()), 1, 2);
        Verify.denyContainsAny(this.newWith(-1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3, HashBag.newBag()), 3, 4, 5);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4, 5).selectWith(Predicates2.lessThan(), 3, HashBag.newBag()), 1, 2);
    }

    @Test
    public void reject() {
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).reject(Predicates.lessThan(3)), 3, 4);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).reject(Predicates.lessThan(3), UnifiedSet.newSet()), 3, 4);
    }

    @Test
    public void rejectWith() {
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).rejectWith(Predicates2.lessThan(), 3), 3, 4);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).rejectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()), 3, 4);
    }

    @Test
    public void rejectWith_target() {
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).rejectWith(Predicates2.lessThan(), 3, HashBag.newBag()), 3, 4);
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).rejectWith(Predicates2.lessThan(), 3, UnifiedSet.newSet()), 3, 4);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<Number> numbers = this.newWith(1, 2.0, 3, 4.0, 5);
        Assert.assertEquals(HashBag.newBagWith(1, 3, 5), numbers.selectInstancesOf(Integer.class).toBag());
        Assert.assertEquals(HashBag.newBagWith(1, 2.0, 3, 4.0, 5), numbers.selectInstancesOf(Number.class).toBag());
    }

    @Test
    public void collect() {
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).collect(String::valueOf), "1", "2", "3", "4");
        Verify.assertContainsAll(this.newWith(1, 2, 3, 4).collect(String::valueOf, UnifiedSet.newSet()), "1", "2", "3", "4");
    }

    @Test
    public void collectTarget() {
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collect(each -> each + 1, Lists.mutable.empty()).toBag());
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), Bags.mutable.withAll(this.newWith(1, 2, 3).collect(each -> each + 1, new ArrayList<>())));
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), Bags.mutable.withAll(this.newWith(1, 2, 3).collect(each -> each + 1, new CopyOnWriteArrayList<>())));
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collect(each -> each + 1, Bags.mutable.empty()));
        Assert.assertEquals(Sets.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collect(each -> each + 1, Sets.mutable.empty()));
        Assert.assertEquals(Sets.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collect(each -> each + 1, new HashSet<>()));
        Assert.assertEquals(Sets.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collect(each -> each + 1, new CopyOnWriteArraySet<>()));
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1, 0).collectBoolean(PrimitiveFunctions.integerIsPositive());
        Assert.assertEquals(BooleanBags.mutable.of(true, false), result.toBag());
        Assert.assertEquals(BooleanBags.mutable.of(true, false), BooleanBags.mutable.ofAll(result));
    }

    @Test
    public void collectBooleanWithTarget() {
        MutableBooleanCollection target = new BooleanArrayList();
        BooleanIterable result = this.newWith(1, 0).collectBoolean(PrimitiveFunctions.integerIsPositive(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(BooleanBags.mutable.of(true, false), result.toBag());
    }

    @Test
    public void collectBooleanWithBagTarget() {
        BooleanHashBag target = new BooleanHashBag();
        BooleanHashBag result = this.newWith(1, 0).collectBoolean(PrimitiveFunctions.integerIsPositive(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false), result);
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1, 2, 3, 4).collectByte(PrimitiveFunctions.unboxIntegerToByte());
        Assert.assertEquals(ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4), result.toBag());
        Assert.assertEquals(ByteBags.mutable.of((byte) 1, (byte) 2, (byte) 3, (byte) 4), ByteBags.mutable.ofAll(result));
    }

    @Test
    public void collectByteWithTarget() {
        MutableByteCollection target = new ByteArrayList();
        ByteIterable result = this.newWith(1, 2, 3, 4).collectByte(PrimitiveFunctions.unboxIntegerToByte(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), result.toBag());
    }

    @Test
    public void collectByteWithBagTarget() {
        ByteHashBag target = new ByteHashBag();
        ByteHashBag result = this.newWith(1, 2, 3, 4).collectByte(PrimitiveFunctions.unboxIntegerToByte(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3, (byte) 4), result);
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1, 2, 3, 4).collectChar(PrimitiveFunctions.unboxIntegerToChar());
        Assert.assertEquals(CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4), result.toBag());
        Assert.assertEquals(CharBags.mutable.of((char) 1, (char) 2, (char) 3, (char) 4), CharBags.mutable.ofAll(result));
    }

    @Test
    public void collectCharWithTarget() {
        MutableCharCollection target = new CharArrayList();
        CharIterable result = this.newWith(1, 2, 3, 4).collectChar(PrimitiveFunctions.unboxIntegerToChar(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4), result.toBag());
    }

    @Test
    public void collectCharWithBagTarget() {
        CharHashBag target = new CharHashBag();
        CharHashBag result = this.newWith(1, 2, 3, 4).collectChar(PrimitiveFunctions.unboxIntegerToChar(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3, (char) 4), result);
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1, 2, 3, 4).collectDouble(PrimitiveFunctions.unboxIntegerToDouble());
        Assert.assertEquals(DoubleBags.mutable.of(1.0d, 2.0d, 3.0d, 4.0d), result.toBag());
        Assert.assertEquals(DoubleBags.mutable.of(1.0d, 2.0d, 3.0d, 4.0d), DoubleBags.mutable.ofAll(result));
    }

    @Test
    public void collectDoubleWithTarget() {
        MutableDoubleCollection target = new DoubleArrayList();
        DoubleIterable result = this.newWith(1, 2, 3, 4).collectDouble(PrimitiveFunctions.unboxIntegerToDouble(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0d, 2.0d, 3.0d, 4.0d), result.toBag());
    }

    @Test
    public void collectDoubleWithBagTarget() {
        DoubleHashBag target = new DoubleHashBag();
        DoubleHashBag result = this.newWith(1, 2, 3, 4).collectDouble(PrimitiveFunctions.unboxIntegerToDouble(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0d, 2.0d, 3.0d, 4.0d), result);
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1, 2, 3, 4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat());
        Assert.assertEquals(FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f), result.toBag());
        Assert.assertEquals(FloatBags.mutable.of(1.0f, 2.0f, 3.0f, 4.0f), FloatBags.mutable.ofAll(result));
    }

    @Test
    public void collectFloatWithTarget() {
        MutableFloatCollection target = new FloatArrayList();
        FloatIterable result = this.newWith(1, 2, 3, 4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f), result.toBag());
    }

    @Test
    public void collectFloatWithBagTarget() {
        FloatHashBag target = new FloatHashBag();
        FloatHashBag result = this.newWith(1, 2, 3, 4).collectFloat(PrimitiveFunctions.unboxIntegerToFloat(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f, 4.0f), result);
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1, 2, 3, 4).collectInt(PrimitiveFunctions.unboxIntegerToInt());
        Assert.assertEquals(IntBags.mutable.of(1, 2, 3, 4), result.toBag());
        Assert.assertEquals(IntBags.mutable.of(1, 2, 3, 4), IntBags.mutable.ofAll(result));
    }

    @Test
    public void collectIntWithTarget() {
        MutableIntCollection target = new IntArrayList();
        IntIterable result = this.newWith(1, 2, 3, 4).collectInt(PrimitiveFunctions.unboxIntegerToInt(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4), result.toBag());
    }

    @Test
    public void collectIntWithBagTarget() {
        IntHashBag target = new IntHashBag();
        IntHashBag result = this.newWith(1, 2, 3, 4).collectInt(PrimitiveFunctions.unboxIntegerToInt(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3, 4), result);
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1, 2, 3, 4).collectLong(PrimitiveFunctions.unboxIntegerToLong());
        Assert.assertEquals(LongBags.mutable.of(1, 2, 3, 4), result.toBag());
        Assert.assertEquals(LongBags.mutable.of(1, 2, 3, 4), LongBags.mutable.ofAll(result));
    }

    @Test
    public void collectLongWithTarget() {
        MutableLongCollection target = new LongArrayList();
        LongIterable result = this.newWith(1, 2, 3, 4).collectLong(PrimitiveFunctions.unboxIntegerToLong(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(LongHashBag.newBagWith(1, 2, 3, 4), result.toBag());
    }

    @Test
    public void collectLongWithBagTarget() {
        LongHashBag target = new LongHashBag();
        LongHashBag result = this.newWith(1, 2, 3, 4).collectLong(PrimitiveFunctions.unboxIntegerToLong(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(LongHashBag.newBagWith(1, 2, 3, 4), result);
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1, 2, 3, 4).collectShort(PrimitiveFunctions.unboxIntegerToShort());
        Assert.assertEquals(ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4), result.toBag());
        Assert.assertEquals(ShortBags.mutable.of((short) 1, (short) 2, (short) 3, (short) 4), ShortBags.mutable.ofAll(result));
    }

    @Test
    public void collectShortWithTarget() {
        MutableShortCollection target = new ShortArrayList();
        ShortIterable result = this.newWith(1, 2, 3, 4).collectShort(PrimitiveFunctions.unboxIntegerToShort(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4), result.toBag());
    }

    @Test
    public void collectShortWithBagTarget() {
        ShortHashBag target = new ShortHashBag();
        ShortHashBag result = this.newWith(1, 2, 3, 4).collectShort(PrimitiveFunctions.unboxIntegerToShort(), target);
        Assert.assertSame("Target list sent as parameter not returned", target, result);
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3, (short) 4), result);
    }

    @Test
    public void flatCollect() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4);
        Function<Integer, MutableList<String>> function = object -> Lists.mutable.with(String.valueOf(object));
        Verify.assertListsEqual(Lists.mutable.with("1", "2", "3", "4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1", "2", "3", "4"), collection.flatCollect(function, UnifiedSet.newSet()));
    }

    @Test
    public void flatCollectWith() {
        RichIterable<Integer> collection = this.newWith(4, 5, 6, 7);
        Verify.assertSetsEqual(Sets.mutable.with(1, 2, 3, 4, 5, 6, 7), collection.flatCollectWith(Interval::fromTo, 1).toSet());
        Verify.assertBagsEqual(Bags.mutable.with(4, 3, 2, 1, 5, 4, 3, 2, 1, 6, 5, 4, 3, 2, 1, 7, 6, 5, 4, 3, 2, 1), collection.flatCollectWith(Interval::fromTo, 1, Bags.mutable.empty()));
    }

    @Test
    public void flatCollectBoolean() {
        RichIterable<BooleanBooleanPair> iterable = this.newWith(PrimitiveTuples.pair(true, false), PrimitiveTuples.pair(false, true));
        Function<BooleanBooleanPair, BooleanIterable> function = pair -> BooleanLists.mutable.with(pair.getOne(), pair.getTwo());
        MutableBooleanBag bag = iterable.flatCollectBoolean(function, new BooleanHashBag());
        MutableBooleanSet set = iterable.flatCollectBoolean(function, new BooleanHashSet());
        BooleanBag expected = BooleanBags.mutable.with(true, false, false, true);
        Assert.assertEquals(expected, bag);
        Assert.assertEquals(expected.toSet(), set);
    }

    @Test
    public void flatCollectByte() {
        RichIterable<ByteBytePair> iterable = this.newWith(PrimitiveTuples.pair((byte) 1, (byte) 2), PrimitiveTuples.pair((byte) 3, (byte) 4));
        Function<ByteBytePair, ByteIterable> function = pair -> ByteLists.mutable.with(pair.getOne(), pair.getTwo());
        MutableByteBag bag = iterable.flatCollectByte(function, new ByteHashBag());
        MutableByteSet set = iterable.flatCollectByte(function, new ByteHashSet());
        ByteBag expected = ByteBags.mutable.with((byte) 1, (byte) 2, (byte) 3, (byte) 4);
        Assert.assertEquals(expected, bag);
        Assert.assertEquals(expected.toSet(), set);
    }

    @Test
    public void flatCollectShort() {
        RichIterable<ShortShortPair> iterable = this.newWith(PrimitiveTuples.pair((short) 1, (short) 2), PrimitiveTuples.pair((short) 3, (short) 4));
        Function<ShortShortPair, ShortIterable> function = pair -> ShortLists.mutable.with(pair.getOne(), pair.getTwo());
        MutableShortBag bag = iterable.flatCollectShort(function, new ShortHashBag());
        MutableShortSet set = iterable.flatCollectShort(function, new ShortHashSet());
        ShortBag expected = ShortBags.mutable.with((short) 1, (short) 2, (short) 3, (short) 4);
        Assert.assertEquals(expected, bag);
        Assert.assertEquals(expected.toSet(), set);
    }

    @Test
    public void flatCollectInt() {
        RichIterable<IntIntPair> iterable = this.newWith(PrimitiveTuples.pair(1, 2), PrimitiveTuples.pair(3, 4));
        Function<IntIntPair, IntIterable> function = pair -> IntLists.mutable.with(pair.getOne(), pair.getTwo());
        MutableIntBag bag = iterable.flatCollectInt(function, new IntHashBag());
        MutableIntSet set = iterable.flatCollectInt(function, new IntHashSet());
        IntBag expected = IntBags.mutable.with(1, 2, 3, 4);
        Assert.assertEquals(expected, bag);
        Assert.assertEquals(expected.toSet(), set);
    }

    @Test
    public void flatCollectChar() {
        RichIterable<CharCharPair> iterable = this.newWith(PrimitiveTuples.pair('a', 'b'), PrimitiveTuples.pair('c', 'd'));
        Function<CharCharPair, CharIterable> function = pair -> CharLists.mutable.with(pair.getOne(), pair.getTwo());
        MutableCharBag bag = iterable.flatCollectChar(function, new CharHashBag());
        MutableCharSet set = iterable.flatCollectChar(function, new CharHashSet());
        CharBag expected = CharBags.mutable.with('a', 'b', 'c', 'd');
        Assert.assertEquals(expected, bag);
        Assert.assertEquals(expected.toSet(), set);
    }

    @Test
    public void flatCollectLong() {
        RichIterable<LongLongPair> iterable = this.newWith(PrimitiveTuples.pair(1L, 2L), PrimitiveTuples.pair(3L, 4L));
        Function<LongLongPair, LongIterable> function = pair -> LongLists.mutable.with(pair.getOne(), pair.getTwo());
        MutableLongBag bag = iterable.flatCollectLong(function, new LongHashBag());
        MutableLongSet set = iterable.flatCollectLong(function, new LongHashSet());
        LongBag expected = LongBags.mutable.with(1L, 2L, 3L, 4L);
        Assert.assertEquals(expected, bag);
        Assert.assertEquals(expected.toSet(), set);
    }

    @Test
    public void flatCollectDouble() {
        RichIterable<DoubleDoublePair> iterable = this.newWith(PrimitiveTuples.pair(1.0, 2.0), PrimitiveTuples.pair(3.0, 4.0));
        Function<DoubleDoublePair, DoubleIterable> function = pair -> DoubleSets.mutable.with(pair.getOne(), pair.getTwo());
        MutableDoubleBag bag = iterable.flatCollectDouble(function, new DoubleHashBag());
        MutableDoubleSet set = iterable.flatCollectDouble(function, new DoubleHashSet());
        DoubleBag expected = DoubleBags.mutable.with(1.0, 2.0, 3.0, 4.0);
        Assert.assertEquals(expected, bag);
        Assert.assertEquals(expected.toSet(), set);
    }

    @Test
    public void flatCollectFloat() {
        RichIterable<FloatFloatPair> iterable = this.newWith(PrimitiveTuples.pair((float) 1, (float) 2), PrimitiveTuples.pair((float) 3, (float) 4));
        Function<FloatFloatPair, FloatIterable> function = pair -> FloatLists.mutable.with(pair.getOne(), pair.getTwo());
        MutableFloatBag bag = iterable.flatCollectFloat(function, new FloatHashBag());
        MutableFloatSet set = iterable.flatCollectFloat(function, new FloatHashSet());
        FloatBag expected = FloatBags.mutable.with(1, 2, 3, 4);
        Assert.assertEquals(expected, bag);
        Assert.assertEquals(expected.toSet(), set);
    }

    @Test
    public void detect() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3, 4, 5).detect(Integer.valueOf(3)::equals));
        Assert.assertNull(this.newWith(1, 2, 3, 4, 5).detect(Integer.valueOf(6)::equals));
    }

    @Test
    public void detectOptional() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3, 4, 5).detectOptional(Integer.valueOf(3)::equals).get());
        Assert.assertNotNull(this.newWith(1, 2, 3, 4, 5).detectOptional(Integer.valueOf(6)::equals));
        Assert.assertThrows(NoSuchElementException.class, () -> this.newWith(1, 2, 3, 4, 5).detectOptional(Integer.valueOf(6)::equals).get());
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws() {
        this.<Integer>newWith().min(Integer::compareTo);
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws() {
        this.<Integer>newWith().max(Integer::compareTo);
    }

    @Test(expected = NullPointerException.class)
    public void min_null_throws() {
        this.newWith(1, null, 2).min(Integer::compareTo);
    }

    @Test(expected = NullPointerException.class)
    public void max_null_throws() {
        this.newWith(1, null, 2).max(Integer::compareTo);
    }

    @Test
    public void min() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 3, 2).min(Integer::compareTo));
    }

    @Test
    public void minOptional() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 3, 2).minOptional().get());
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 3, 2).minOptional(Integer::compareTo).get());
        Assert.assertFalse(this.<Integer>newWith().minOptional().isPresent());
        Assert.assertFalse(this.<Integer>newWith().minOptional(Integer::compareTo).isPresent());
    }

    @Test
    public void max() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 3, 2).max(Integer::compareTo));
    }

    @Test
    public void maxOptional() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 3, 2).maxOptional().get());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 3, 2).maxOptional(Integer::compareTo).get());
        Assert.assertFalse(this.<Integer>newWith().maxOptional().isPresent());
        Assert.assertFalse(this.<Integer>newWith().maxOptional(Integer::compareTo).isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void min_null_throws_without_comparator() {
        this.newWith(1, null, 2).min();
    }

    @Test(expected = NullPointerException.class)
    public void max_null_throws_without_comparator() {
        this.newWith(1, null, 2).max();
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(3, 1, 2).min());
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 3, 2).max());
    }

    @Test
    public void min_null_safe() {
        RichIterable<Integer> integers = this.newWith(1, 3, 2, null);
        Assert.assertEquals(Integer.valueOf(1), integers.min(Comparators.safeNullsHigh(Integer::compareTo)));
        Assert.assertNull(integers.min(Comparators.safeNullsLow(Integer::compareTo)));
    }

    @Test
    public void max_null_safe() {
        RichIterable<Integer> integers = this.newWith(1, 3, 2, null);
        Assert.assertEquals(Integer.valueOf(3), integers.max(Comparators.safeNullsLow(Integer::compareTo)));
        Assert.assertNull(integers.max(Comparators.safeNullsHigh(Integer::compareTo)));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 3, 2).minBy(String::valueOf));
    }

    @Test
    public void minByOptional() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 3, 2).minByOptional(String::valueOf).get());
        Assert.assertFalse(this.newWith().minByOptional(String::valueOf).isPresent());
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 3, 2).maxBy(String::valueOf));
    }

    @Test
    public void maxByOptional() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 3, 2).maxByOptional(String::valueOf).get());
        Assert.assertFalse(this.newWith().maxByOptional(String::valueOf).isPresent());
    }

    @Test(expected = NullPointerException.class)
    public void minBy_null_throws() {
        this.newWith(1, null, 2).minBy(Integer::valueOf);
    }

    @Test(expected = NullPointerException.class)
    public void maxBy_null_throws() {
        this.newWith(1, null, 2).maxBy(Integer::valueOf);
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3, 4, 5).detectWith(Object::equals, 3));
        Assert.assertNull(this.newWith(1, 2, 3, 4, 5).detectWith(Object::equals, 6));
    }

    @Test
    public void detectWithOptional() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3, 4, 5).detectWithOptional(Object::equals, 3).get());
        Assert.assertNotNull(this.newWith(1, 2, 3, 4, 5).detectWithOptional(Object::equals, 6));
        Assert.assertThrows(NoSuchElementException.class, () -> this.newWith(1, 2, 3, 4, 5).detectWithOptional(Object::equals, 6).get());
    }

    @Test
    public void detectIfNone() {
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(3)::equals, () -> 6));
        Assert.assertEquals(Integer.valueOf(6), this.newWith(1, 2, 3, 4, 5).detectIfNone(Integer.valueOf(6)::equals, () -> 6));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<Integer> function = new PassThruFunction0<>(-42);
        Assert.assertEquals(Integer.valueOf(5), this.newWith(1, 2, 3, 4, 5).detectWithIfNone(Predicates2.greaterThan(), 4, function));
        Assert.assertEquals(Integer.valueOf(-42), this.newWith(1, 2, 3, 4, 5).detectWithIfNone(Predicates2.lessThan(), 0, function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1, 2, 3).allSatisfy(Integer.class::isInstance));
        Assert.assertFalse(this.newWith(1, 2, 3).allSatisfy(Integer.valueOf(1)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1, 2, 3).allSatisfyWith(Predicates2.instanceOf(), Integer.class));
        Assert.assertFalse(this.newWith(1, 2, 3).allSatisfyWith(Object::equals, 1));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1, 2, 3).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1, 1, 3).noneSatisfy(Integer.valueOf(1)::equals));
        Assert.assertTrue(this.newWith(1, 2, 3).noneSatisfy(Integer.valueOf(4)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1, 2, 3).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1, 2, 3).noneSatisfyWith(Object::equals, 1));
    }

    @Test
    public void anySatisfy() {
        Assert.assertFalse(this.newWith(1, 2, 3).anySatisfy(String.class::isInstance));
        Assert.assertTrue(this.newWith(1, 2, 3).anySatisfy(Integer.class::isInstance));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertFalse(this.newWith(1, 2, 3).anySatisfyWith(Predicates2.instanceOf(), String.class));
        Assert.assertTrue(this.newWith(1, 2, 3).anySatisfyWith(Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void count() {
        Assert.assertEquals(3, this.newWith(1, 2, 3).count(Integer.class::isInstance));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(3, this.newWith(1, 2, 3).countWith(Predicates2.instanceOf(), Integer.class));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1, 2, 3).collectIf(Integer.class::isInstance, Object::toString), "1", "2", "3");
        Verify.assertContainsAll(this.newWith(1, 2, 3).collectIf(Integer.class::isInstance, Object::toString, UnifiedSet.newSet()), "1", "2", "3");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1, Lists.mutable.empty()).toBag());
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), Bags.mutable.withAll(this.newWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1, new ArrayList<>())));
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), Bags.mutable.withAll(this.newWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1, new CopyOnWriteArrayList<>())));
        Assert.assertEquals(Bags.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1, Bags.mutable.empty()));
        Assert.assertEquals(Sets.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1, Sets.mutable.empty()));
        Assert.assertEquals(Sets.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1, new HashSet<>()));
        Assert.assertEquals(Sets.mutable.of(2, 3, 4), this.newWith(1, 2, 3).collectWith(AddFunction.INTEGER, 1, new CopyOnWriteArraySet<>()));
    }

    @Test
    public void getAny() {
        RichIterable<Integer> distinctElements = this.newWith(1, 2, 3);
        Assert.assertTrue(distinctElements.contains(distinctElements.getAny()));
        RichIterable<String> duplicateElements = this.newWith("a", "a", "b");
        Assert.assertTrue(duplicateElements.contains(duplicateElements.getAny()));
    }

    @Test
    public void getFirst() {
        Assert.assertEquals(Integer.valueOf(1), this.newWith(1, 2, 3).getFirst());
        Assert.assertNotEquals(Integer.valueOf(3), this.newWith(1, 2, 3).getFirst());
    }

    @Test
    public void getLast() {
        Assert.assertNotEquals(Integer.valueOf(1), this.newWith(1, 2, 3).getLast());
        Assert.assertEquals(Integer.valueOf(3), this.newWith(1, 2, 3).getLast());
    }

    @Test
    public void getOnly() {
        Assert.assertEquals(Integer.valueOf(2), this.newWith(2).getOnly());
        Assert.assertNotEquals(Integer.valueOf(2), this.newWith(1).getOnly());
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_not_only_one_throws() {
        this.newWith(1, 2).getOnly();
    }

    @Test(expected = IllegalStateException.class)
    public void getOnly_empty_throws() {
        this.newWith().getOnly();
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1, 2));
        Assert.assertTrue(this.newWith(1, 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        Iterator<Integer> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            Integer integer = iterator.next();
            Assert.assertEquals(3, integer.intValue() + i);
        }
        Assert.assertFalse(iterator.hasNext());
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_throws() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        Iterator<Integer> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test
    public void injectInto() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        Integer result = objects.injectInto(1, AddFunction.INTEGER);
        Assert.assertEquals(Integer.valueOf(7), result);
        int sum = objects.injectInto(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(6, sum);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        int result = objects.injectIntoInt(1, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(7, result);
        int sum = objects.injectIntoInt(0, AddFunction.INTEGER_TO_INT);
        Assert.assertEquals(6, sum);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        long result = objects.injectIntoLong(1, AddFunction.INTEGER_TO_LONG);
        Assert.assertEquals(7, result);
        long sum = objects.injectIntoLong(0, AddFunction.INTEGER_TO_LONG);
        Assert.assertEquals(6, sum);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        double result = objects.injectIntoDouble(1, AddFunction.INTEGER_TO_DOUBLE);
        Assert.assertEquals(7.0d, result, 0.001);
        double sum = objects.injectIntoDouble(0, AddFunction.INTEGER_TO_DOUBLE);
        Assert.assertEquals(6.0d, sum, 0.001);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        float result = objects.injectIntoFloat(1, AddFunction.INTEGER_TO_FLOAT);
        Assert.assertEquals(7.0f, result, 0.001f);
        float sum = objects.injectIntoFloat(0, AddFunction.INTEGER_TO_FLOAT);
        Assert.assertEquals(6.0f, sum, 0.001f);
    }

    @Test
    public void sumFloat() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        float expected = objects.injectInto(0, AddFunction.INTEGER_TO_FLOAT);
        double actual = objects.sumOfFloat(Integer::floatValue);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void summarizeFloat() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        DoubleSummaryStatistics expected = objects.summarizeFloat(Integer::floatValue);
        Assert.assertEquals(6.0d, expected.getSum(), 0.0);
        Assert.assertEquals(3, expected.getCount());
    }

    @Test
    public void sumFloatConsistentRounding1() {
        MutableList<Integer> list = Interval.oneTo(100_000).toList().shuffleThis();
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed, the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, this.newWith(list.toArray(new Integer[] {})).sumOfFloat(i -> 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue())), 1.0e-15);
    }

    @Test
    public void sumFloatConsistentRounding2() {
        MutableList<Integer> list = Interval.oneTo(99_999).toList().shuffleThis();
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed, the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(33333.00099340081, this.newWith(list.toArray(new Integer[] {})).sumOfFloat(i -> 1.0f / 3.0f), 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        double expected = objects.injectInto(0, AddFunction.INTEGER_TO_DOUBLE);
        double actual = objects.sumOfDouble(Integer::doubleValue);
        Assert.assertEquals(expected, actual, 0.001);
    }

    @Test
    public void summarizeDouble() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        DoubleSummaryStatistics expected = objects.summarizeDouble(Integer::doubleValue);
        Assert.assertEquals(6.0d, expected.getSum(), 0.0);
        Assert.assertEquals(3, expected.getCount());
    }

    @Test
    public void sumDoubleConsistentRounding1() {
        MutableList<Integer> list = Interval.oneTo(100_000).toList().shuffleThis();
        Assert.assertEquals(1.082323233711138, this.newWith(list.toArray(new Integer[] {})).sumOfDouble(i -> 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue())), 1.0e-15);
    }

    @Test
    public void sumDoubleConsistentRounding2() {
        MutableList<Integer> list = Interval.oneTo(99_999).toList().shuffleThis();
        Assert.assertEquals(33333.0, this.newWith(list.toArray(new Integer[] {})).sumOfDouble(i -> 1.0d / 3.0d), 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        long expected = objects.injectInto(0L, AddFunction.INTEGER_TO_LONG);
        long actual = objects.sumOfInt(integer -> integer);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void summarizeInt() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        IntSummaryStatistics expected = objects.summarizeInt(Integer::intValue);
        Assert.assertEquals(6, expected.getSum());
        Assert.assertEquals(3, expected.getCount());
    }

    @Test
    public void sumLong() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        long expected = objects.injectInto(0L, AddFunction.INTEGER_TO_LONG);
        long actual = objects.sumOfLong(Integer::longValue);
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void summarizeLong() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        LongSummaryStatistics expected = objects.summarizeLong(Integer::longValue);
        Assert.assertEquals(6, expected.getSum());
        Assert.assertEquals(3, expected.getCount());
    }

    @Test
    public void sumByInt() {
        RichIterable<Integer> values = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ObjectLongMap<Integer> result = values.sumByInt(i -> i % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    @Test
    public void sumByFloat() {
        RichIterable<Integer> values = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ObjectDoubleMap<Integer> result = values.sumByFloat(f -> f % 2, e -> e);
        Assert.assertEquals(25.0f, result.get(1), 0.0);
        Assert.assertEquals(30.0f, result.get(0), 0.0);
    }

    @Test
    public void sumByFloatConsistentRounding() {
        MutableList<Integer> group1 = Interval.oneTo(100_000).toList().shuffleThis();
        MutableList<Integer> group2 = Interval.fromTo(100_001, 200_000).toList().shuffleThis();
        MutableList<Integer> integers = Lists.mutable.withAll(group1);
        integers.addAll(group2);
        ObjectDoubleMap<Integer> result = integers.sumByFloat(integer -> integer > 100_000 ? 2 : 1, integer -> {
            Integer i = integer > 100_000 ? integer - 100_000 : integer;
            return 1.0f / (i.floatValue() * i.floatValue() * i.floatValue() * i.floatValue());
        });
        // The test only ensures the consistency/stability of rounding. This is not meant to test the "correctness" of the float calculation result.
        // Indeed, the lower bits of this calculation result are always incorrect due to the information loss of original float values.
        Assert.assertEquals(1.082323233761663, result.get(1), 1.0e-15);
        Assert.assertEquals(1.082323233761663, result.get(2), 1.0e-15);
    }

    @Test
    public void sumByLong() {
        RichIterable<Integer> values = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ObjectLongMap<Integer> result = values.sumByLong(l -> l % 2, e -> e);
        Assert.assertEquals(25, result.get(1));
        Assert.assertEquals(30, result.get(0));
    }

    @Test
    public void sumByDouble() {
        RichIterable<Integer> values = this.newWith(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        ObjectDoubleMap<Integer> result = values.sumByDouble(d -> d % 2, e -> e);
        Assert.assertEquals(25.0d, result.get(1), 0.0);
        Assert.assertEquals(30.0d, result.get(0), 0.0);
    }

    @Test
    public void sumByDoubleConsistentRounding() {
        MutableList<Integer> group1 = Interval.oneTo(100_000).toList().shuffleThis();
        MutableList<Integer> group2 = Interval.fromTo(100_001, 200_000).toList().shuffleThis();
        MutableList<Integer> integers = Lists.mutable.withAll(group1);
        integers.addAll(group2);
        ObjectDoubleMap<Integer> result = integers.sumByDouble(integer -> integer > 100_000 ? 2 : 1, integer -> {
            Integer i = integer > 100_000 ? integer - 100_000 : integer;
            return 1.0d / (i.doubleValue() * i.doubleValue() * i.doubleValue() * i.doubleValue());
        });
        Assert.assertEquals(1.082323233711138, result.get(1), 1.0e-15);
        Assert.assertEquals(1.082323233711138, result.get(2), 1.0e-15);
    }

    @Test
    public void toArray() {
        RichIterable<Integer> objects = this.newWith(1, 2, 3);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        Integer[] array2 = objects.toArray(new Integer[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        RichIterable<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionIterable<Integer> result = integers.partition(IntegerPredicates.isEven());
        Assert.assertEquals(this.newWith(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(this.newWith(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Test
    public void partitionWith() {
        RichIterable<Integer> integers = this.newWith(-3, -2, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        PartitionIterable<Integer> result = integers.partitionWith(Predicates2.in(), Lists.mutable.with(-2, 0, 2, 4, 6, 8));
        Assert.assertEquals(this.newWith(-2, 0, 2, 4, 6, 8), result.getSelected());
        Assert.assertEquals(this.newWith(-3, -1, 1, 3, 5, 7, 9), result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<Integer> list = this.newWith(1, 2, 3, 4).toList();
        Assert.assertEquals(Lists.immutable.with(1, 2, 3, 4), list);
    }

    @Test
    public void toImmutableList() {
        ImmutableList<Integer> list = this.newWith(1, 2, 3, 4).toImmutableList();
        Verify.assertContainsAll(list, 1, 2, 3, 4);
        ImmutableList<Integer> singletonList = this.newWith(1).toImmutableList();
        Assert.assertEquals(Lists.mutable.with(1), singletonList);
        ImmutableList<Integer> emptyList = this.<Integer>newWith().toImmutableList();
        Assert.assertEquals(Lists.immutable.empty(), emptyList);
    }

    @Test
    public void toCollection() {
        MutableList<Integer> list = this.newWith(1, 2, 3, 4).into(Lists.mutable.with(0));
        Verify.assertContainsAll(list, 0, 1, 2, 3, 4);
    }

    @Test
    public void toBag() {
        MutableBag<Integer> bag = this.newWith(1, 2, 3, 4).toBag();
        Assert.assertEquals(Bags.immutable.with(1, 2, 3, 4), bag);
    }

    @Test
    public void toImmutableBag() {
        ImmutableBag<Integer> bag = this.newWith(1, 2, 3, 4).toImmutableBag();
        Assert.assertEquals(Bags.mutable.with(1, 2, 3, 4), bag);
        ImmutableBag<Integer> singletonBag = this.newWith(1).toImmutableBag();
        Assert.assertEquals(Bags.mutable.with(1), singletonBag);
        ImmutableBag<Integer> emptyBag = this.<Integer>newWith().toImmutableBag();
        Assert.assertEquals(Bags.immutable.empty(), emptyBag);
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<Integer> integers = this.newWith(2, 1, 5, 3, 4);
        MutableList<Integer> list = integers.toSortedList();
        Verify.assertStartsWith(list, 1, 2, 3, 4, 5);
    }

    @Test
    public void toImmutableSortedList_natural_ordering() {
        ImmutableList<Integer> list = this.newWith(4, 2, 1, 3).toImmutableSortedList();
        Assert.assertEquals(Lists.mutable.with(1, 2, 3, 4), list);
        ImmutableList<Integer> singletonList = this.newWith(1).toImmutableSortedList();
        Assert.assertEquals(Lists.mutable.with(1), singletonList);
        ImmutableList<Integer> emptyList = this.<Integer>newWith().toImmutableSortedList();
        Assert.assertEquals(Lists.immutable.empty(), emptyList);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableList<Integer> list = integers.toSortedList(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.with(4, 3, 2, 1), list);
    }

    @Test
    public void toImmutableSortedList_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        ImmutableList<Integer> list = integers.toImmutableSortedList(Collections.reverseOrder());
        Assert.assertEquals(Lists.mutable.with(4, 3, 2, 1), list);
    }

    @Test(expected = NullPointerException.class)
    public void toSortedList_with_null() {
        this.newWith(2, 4, null, 1, 3).toSortedList();
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<Integer> integers = this.newWith(2, 2, 5, 3, 4);
        MutableSortedBag<Integer> bag = integers.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(2, 2, 3, 4, 5), bag);
    }

    @Test
    public void toImmutableSortedBag_natural_ordering() {
        ImmutableSortedBag<Integer> bag = this.newWith(4, 1, 2, 3).toImmutableSortedBag();
        Assert.assertEquals(SortedBags.mutable.with(1, 2, 3, 4), bag);
        ImmutableSortedBag<Integer> singletonBag = this.newWith(1).toImmutableSortedBag();
        Assert.assertEquals(SortedBags.mutable.with(1), singletonBag);
        ImmutableSortedBag<Integer> emptyBag = this.<Integer>newWith().toImmutableSortedBag();
        Assert.assertEquals(SortedBags.immutable.empty(), emptyBag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 2, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 2), bag);
    }

    @Test
    public void toImmutableSortedBag_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 2, 3);
        ImmutableSortedBag<Integer> bag = integers.toImmutableSortedBag(Collections.reverseOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Collections.reverseOrder(), 4, 3, 2, 2), bag);
    }

    @Test(expected = NullPointerException.class)
    public void toSortedBag_with_null() {
        this.newWith(2, 4, null, 1, 2).toSortedBag();
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedBag<Integer> bag = integers.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), bag);
    }

    @Test
    public void toImmutableSortedBagBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        ImmutableSortedBag<Integer> bag = integers.toImmutableSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(1, 2, 3, 4), bag);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableList<Integer> list = integers.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.with(1, 2, 3, 4), list);
    }

    @Test
    public void toImmutableSortedListBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        ImmutableList<Integer> list = integers.toImmutableSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.with(1, 2, 3, 4), list);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3, 2, 1, 3, 4);
        MutableSortedSet<Integer> set = integers.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), set);
    }

    @Test
    public void toImmutableSortSet_natural_ordering() {
        ImmutableSortedSet<Integer> set = this.newWith(2, 1, 4, 3).toImmutableSortedSet();
        Assert.assertEquals(SortedSets.mutable.with(1, 2, 3, 4), set);
        ImmutableSortedSet<Integer> singletonSet = this.newWith(1).toImmutableSortedSet();
        Assert.assertEquals(SortedSets.mutable.with(1), singletonSet);
        ImmutableSortedSet<Integer> emptySet = this.<Integer>newWith().toImmutableSortedSet();
        Assert.assertEquals(SortedSets.immutable.empty(), emptySet);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 4, 2, 1, 4, 1, 3);
        MutableSortedSet<Integer> set = integers.toSortedSet(Collections.reverseOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 1, 2, 3, 4), set);
    }

    @Test
    public void toImmutableSortedSet_with_comparator() {
        RichIterable<Integer> integers = this.newWith(2, 4, 4, 2, 1, 4, 1, 3);
        ImmutableSortedSet<Integer> set = integers.toImmutableSortedSet(Collections.reverseOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Collections.reverseOrder(), 1, 2, 3, 4), set.castToSortedSet());
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        MutableSortedSet<Integer> set = integers.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), set);
    }

    @Test
    public void toImmutableSortedSetBy() {
        RichIterable<Integer> integers = this.newWith(2, 4, 1, 3);
        ImmutableSortedSet<Integer> set = integers.toImmutableSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(1, 2, 3, 4), set.castToSortedSet());
    }

    @Test(expected = NullPointerException.class)
    public void toSortedListBy_with_null() {
        this.newWith(2, 4, null, 1, 3).toSortedListBy(Functions.getIntegerPassThru());
    }

    @Test
    public void toSet() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3, 4);
        MutableSet<Integer> set = integers.toSet();
        Assert.assertEquals(Sets.immutable.with(1, 2, 3, 4), set);
    }

    @Test
    public void toImmutableSet() {
        ImmutableSet<Integer> set = this.newWith(1, 2, 3, 4).toImmutableSet();
        Assert.assertEquals(Sets.mutable.with(1, 2, 3, 4), set);
        ImmutableSet<Integer> singletonSet = this.newWith(1).toImmutableSet();
        Assert.assertEquals(Sets.mutable.with(1), singletonSet);
        ImmutableSet<Integer> emptySet = this.<Integer>newWith().toImmutableSet();
        Assert.assertEquals(Sets.immutable.empty(), emptySet);
    }

    @Test
    public void toMap() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3, 4);
        MutableMap<String, String> map = integers.toMap(Object::toString, Object::toString);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "1", "2", "2", "3", "3", "4", "4"), map);
    }

    @Test
    public void toImmutableMap() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3, 4);
        ImmutableMap<String, String> map = integers.toImmutableMap(Object::toString, Object::toString);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1", "1", "2", "2", "3", "3", "4", "4"), map);
        RichIterable<Integer> empty = this.newWith();
        ImmutableMap<String, String> emptyMap = empty.toImmutableMap(Object::toString, Object::toString);
        Assert.assertSame(Maps.immutable.empty(), emptyMap);
    }

    @Test
    public void toMapTarget() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3, 4);
        Map<String, String> jdkMap = new HashMap<>();
        jdkMap.put("1", "1");
        jdkMap.put("2", "2");
        jdkMap.put("3", "3");
        jdkMap.put("4", "4");
        Map<String, String> targetMap = integers.toMap(Object::toString, Object::toString, new HashMap<>());
        Assert.assertEquals(jdkMap, targetMap);
        Assert.assertTrue(targetMap instanceof HashMap);
    }

    @Test
    public void toSortedMap() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3);
        MutableSortedMap<Integer, String> map = integers.toSortedMap(Functions.getIntegerPassThru(), Object::toString);
        Verify.assertMapsEqual(TreeSortedMap.newMapWith(1, "1", 2, "2", 3, "3"), map);
        Verify.assertListsEqual(Lists.mutable.with(1, 2, 3), map.keySet().toList());
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3);
        MutableSortedMap<Integer, String> map = integers.toSortedMap(Comparators.reverseNaturalOrder(), Functions.getIntegerPassThru(), Object::toString);
        Verify.assertMapsEqual(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 3, "3"), map);
        Verify.assertListsEqual(Lists.mutable.with(3, 2, 1), map.keySet().toList());
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3);
        MutableSortedMap<Integer, String> map = integers.toSortedMapBy(key -> -key, Functions.getIntegerPassThru(), Object::toString);
        Verify.assertMapsEqual(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), 1, "1", 2, "2", 3, "3"), map);
        Verify.assertListsEqual(Lists.mutable.with(3, 2, 1), map.keySet().toList());
    }

    @Test
    public void toBiMap() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3);
        Assert.assertEquals(Maps.mutable.with("1", "1", "2", "2", "3", "3"), integers.toBiMap(Object::toString, Object::toString));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.toBiMap(i -> "Constant Key", Objects::toString));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.toBiMap(Object::toString, i -> "Constant Value"));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.toBiMap(i -> "Constant Key", i -> "Constant Value"));
    }

    @Test
    public void toImmutableBiMap() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3);
        Assert.assertEquals(Maps.mutable.with("1", "1", "2", "2", "3", "3"), integers.toImmutableBiMap(Object::toString, Object::toString));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.toImmutableBiMap(i -> "Constant Key", Objects::toString));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.toImmutableBiMap(Object::toString, i -> "Constant Value"));
        Assert.assertThrows(IllegalArgumentException.class, () -> integers.toImmutableBiMap(i -> "Constant Key", i -> "Constant Value"));
    }

    @Test
    public void testToString() {
        RichIterable<Object> collection = this.newWith(1, 2, 3);
        Assert.assertEquals("[1, 2, 3]", collection.toString());
    }

    @Test
    public void makeString() {
        RichIterable<Object> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<Object> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<Object> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void fusedCollectMakeString() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(collection.asLazy().collect(Integer::toUnsignedString).makeString("[", ", ", "]"), collection.makeString(Integer::toUnsignedString, "[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<Object> collection = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<Object> collection = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<Object> collection = this.newWith(1, 2, 3);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void appendStringThrows() {
        Verify.assertThrows(RuntimeException.class, () -> this.newWith(1, 2, 3).appendString(new ThrowingAppendable()));
        Verify.assertThrows(RuntimeException.class, () -> this.newWith(1, 2, 3).appendString(new ThrowingAppendable(), ", "));
        Verify.assertThrows(RuntimeException.class, () -> this.newWith(1, 2, 3).appendString(new ThrowingAppendable(), "[", ", ", "]"));
    }

    /**
     * @since 9.0
     */
    @Test
    public void countBy() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3, 4, 5, 6);
        Bag<Integer> evensAndOdds = integers.countBy(each -> Integer.valueOf(each % 2));
        Assert.assertEquals(3, evensAndOdds.occurrencesOf(1));
        Assert.assertEquals(3, evensAndOdds.occurrencesOf(0));
        Bag<Integer> evensAndOdds2 = integers.countBy(each -> Integer.valueOf(each % 2), Bags.mutable.empty());
        Assert.assertEquals(3, evensAndOdds2.occurrencesOf(1));
        Assert.assertEquals(3, evensAndOdds2.occurrencesOf(0));
    }

    /**
     * @since 9.0
     */
    @Test
    public void countByWith() {
        RichIterable<Integer> integers = this.newWith(1, 2, 3, 4, 5, 6);
        Bag<Integer> evensAndOdds = integers.countByWith((each, parm) -> Integer.valueOf(each % parm), 2);
        Assert.assertEquals(3, evensAndOdds.occurrencesOf(1));
        Assert.assertEquals(3, evensAndOdds.occurrencesOf(0));
        Bag<Integer> evensAndOdds2 = integers.countByWith((each, parm) -> Integer.valueOf(each % parm), 2, Bags.mutable.empty());
        Assert.assertEquals(3, evensAndOdds2.occurrencesOf(1));
        Assert.assertEquals(3, evensAndOdds2.occurrencesOf(0));
    }

    /**
     * @since 10.0.0
     */
    @Test
    public void countByEach() {
        RichIterable<Integer> integerList = this.newWith(1, 2, 4);
        Bag<Integer> integerBag1 = integerList.countByEach(each -> IntInterval.oneTo(5).collect(i -> each * i));
        Assert.assertEquals(1, integerBag1.occurrencesOf(1));
        Assert.assertEquals(2, integerBag1.occurrencesOf(2));
        Assert.assertEquals(3, integerBag1.occurrencesOf(4));
        Assert.assertEquals(2, integerBag1.occurrencesOf(8));
        Assert.assertEquals(1, integerBag1.occurrencesOf(12));
        Bag<Integer> integerBag2 = integerList.countByEach(each -> IntInterval.oneTo(5).collect(i -> each * i), Bags.mutable.empty());
        Assert.assertEquals(1, integerBag2.occurrencesOf(1));
        Assert.assertEquals(2, integerBag2.occurrencesOf(2));
        Assert.assertEquals(3, integerBag2.occurrencesOf(4));
        Assert.assertEquals(2, integerBag2.occurrencesOf(8));
        Assert.assertEquals(1, integerBag2.occurrencesOf(12));
    }

    @Test
    public void groupBy() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4, 5, 6, 7);
        Function<Integer, Boolean> isOddFunction = object -> IntegerPredicates.isOdd().accept(object);
        MutableMap<Boolean, RichIterable<Integer>> expected = UnifiedMap.newWithKeysValues(Boolean.TRUE, this.newWith(1, 3, 5, 7), Boolean.FALSE, this.newWith(2, 4, 6));
        Multimap<Boolean, Integer> multimap = collection.groupBy(isOddFunction);
        Assert.assertEquals(expected, multimap.toMap());
        Function<Integer, Boolean> function = (Integer object) -> true;
        MutableMultimap<Boolean, Integer> multimap2 = collection.groupBy(isOddFunction, this.<Integer>newWith().groupBy(function).toMutable());
        Assert.assertEquals(expected, multimap2.toMap());
    }

    @Test
    public void groupByEach() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3, 4, 5, 6, 7);
        NegativeIntervalFunction function = new NegativeIntervalFunction();
        MutableMultimap<Integer, Integer> expected = this.<Integer>newWith().groupByEach(function).toMutable();
        for (int i = 1; i < 8; i++) {
            expected.putAll(-i, Interval.fromTo(i, 7));
        }
        Multimap<Integer, Integer> actual = collection.groupByEach(function);
        Assert.assertEquals(expected, actual);
        Multimap<Integer, Integer> actualWithTarget = collection.groupByEach(function, this.<Integer>newWith().groupByEach(function).toMutable());
        Assert.assertEquals(expected, actualWithTarget);
    }

    @Test
    public void groupByUniqueKey() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(1, 1, 2, 2, 3, 3), collection.groupByUniqueKey(id -> id));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_throws_for_duplicate() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3);
        collection.groupByUniqueKey(id -> 2);
    }

    @Test
    public void groupByUniqueKey_target() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3), collection.groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(0, 0)));
    }

    @Test(expected = IllegalStateException.class)
    public void groupByUniqueKey_target_throws_for_duplicate() {
        RichIterable<Integer> collection = this.newWith(1, 2, 3);
        Assert.assertEquals(UnifiedMap.newWithKeysValues(0, 0, 1, 1, 2, 2, 3, 3), collection.groupByUniqueKey(id -> id, UnifiedMap.newWithKeysValues(2, 2)));
    }

    @Test
    public void zip() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        List<Object> nulls = Collections.nCopies(collection.size(), null);
        List<Object> nullsPlusOne = Collections.nCopies(collection.size() + 1, null);
        List<Object> nullsMinusOne = Collections.nCopies(collection.size() - 1, null);
        RichIterable<Pair<String, Object>> pairs = collection.zip(nulls);
        Assert.assertEquals(collection.toSet(), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
        Assert.assertEquals(nulls, pairs.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        RichIterable<Pair<String, Object>> pairsPlusOne = collection.zip(nullsPlusOne);
        Assert.assertEquals(collection.toSet(), pairsPlusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
        Assert.assertEquals(nulls, pairsPlusOne.collect((Function<Pair<?, Object>, Object>) Pair::getTwo, Lists.mutable.of()));
        RichIterable<Pair<String, Object>> pairsMinusOne = collection.zip(nullsMinusOne);
        Assert.assertEquals(collection.size() - 1, pairsMinusOne.size());
        Assert.assertTrue(collection.containsAllIterable(pairsMinusOne.collect((Function<Pair<String, ?>, String>) Pair::getOne)));
        Assert.assertEquals(collection.zip(nulls).toSet(), collection.zip(nulls, UnifiedSet.newSet()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        RichIterable<Pair<String, Integer>> pairs = collection.zipWithIndex();
        Assert.assertEquals(collection.toSet(), pairs.collect((Function<Pair<String, ?>, String>) Pair::getOne).toSet());
        Assert.assertEquals(Interval.zeroTo(collection.size() - 1).toSet(), pairs.collect((Function<Pair<?, Integer>, Integer>) Pair::getTwo, UnifiedSet.newSet()));
        Assert.assertEquals(collection.zipWithIndex().toSet(), collection.zipWithIndex(UnifiedSet.newSet()));
    }

    @Test
    public void chunk() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        RichIterable<RichIterable<String>> groups = collection.chunk(2);
        RichIterable<Integer> sizes = groups.collect(RichIterable::size);
        Assert.assertEquals(Lists.mutable.with(2, 2, 2, 1), sizes);
    }

    @Test
    public void chunk_empty() {
        RichIterable<String> collection = this.newWith();
        RichIterable<RichIterable<String>> groups = collection.chunk(2);
        Assert.assertEquals(groups.size(), 0);
    }

    @Test
    public void chunk_single() {
        RichIterable<String> collection = this.newWith("1");
        RichIterable<RichIterable<String>> groups = collection.chunk(2);
        Assert.assertEquals(Lists.mutable.with(1), groups.collect(RichIterable::size));
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<String> collection = this.newWith("1", "2", "3", "4", "5", "6", "7");
        Assert.assertEquals(collection, collection.chunk(10).getOnly());
    }

    @Test
    public void empty() {
        Verify.assertIterableEmpty(this.newWith());
        Assert.assertTrue(this.newWith().isEmpty());
        Assert.assertFalse(this.newWith().notEmpty());
    }

    @Test
    public void notEmpty() {
        RichIterable<Integer> notEmpty = this.newWith(1);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        RichIterable<Integer> collection = this.newWith(1, 1, 1, 2, 2, 3);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, AtomicInteger::new, AtomicInteger::addAndGet);
        if (collection instanceof Set) {
            Assert.assertEquals(1, aggregation.get("1").intValue());
            Assert.assertEquals(2, aggregation.get("2").intValue());
            Assert.assertEquals(3, aggregation.get("3").intValue());
        } else {
            Assert.assertEquals(3, aggregation.get("1").intValue());
            Assert.assertEquals(4, aggregation.get("2").intValue());
            Assert.assertEquals(3, aggregation.get("3").intValue());
        }
    }

    @Test
    public void aggregateByNonMutating() {
        MapIterable<String, Integer> aggregation = this.newWith(1, 1, 1, 2, 2, 3).aggregateBy(Object::toString, () -> 0, (integer1, integer2) -> integer1 + integer2);
        if (this.newWith(1, 1, 1, 2, 2, 3) instanceof Set) {
            Assert.assertEquals(1, aggregation.get("1").intValue());
            Assert.assertEquals(2, aggregation.get("2").intValue());
            Assert.assertEquals(3, aggregation.get("3").intValue());
        } else {
            Assert.assertEquals(3, aggregation.get("1").intValue());
            Assert.assertEquals(4, aggregation.get("2").intValue());
            Assert.assertEquals(3, aggregation.get("3").intValue());
        }
    }

    @Test
    public void reduceOptional() {
        RichIterable<Integer> littleIterable = this.newWith(1, 2, 3);
        Optional<Integer> result = littleIterable.reduce(Integer::sum);
        Assert.assertEquals(6, result.get().intValue());
        RichIterable<Integer> bigIterable = this.newWith(Interval.oneTo(20).toArray());
        Optional<Integer> bigResult = bigIterable.reduce(Integer::max);
        Assert.assertEquals(20, bigResult.get().intValue());
        Optional<Integer> max = littleIterable.reduce(Integer::max);
        Assert.assertEquals(3, max.get().intValue());
        Optional<Integer> min = littleIterable.reduce(Integer::min);
        Assert.assertEquals(1, min.get().intValue());
        RichIterable<Integer> iterableEmpty = this.newWith();
        Optional<Integer> resultEmpty = iterableEmpty.reduce(Integer::sum);
        Assert.assertFalse(resultEmpty.isPresent());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractRichIterableTestCase instance;

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
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.isEmpty);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator);
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
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partitionWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partitionWith);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractRichIterableTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> testNewCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> equalsAndHashCode;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> contains;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> containsBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> containsAnyIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> containsNoneIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> containsAnyCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> containsNoneCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> containsAllCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> tap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectBooleanWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectBooleanWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectByteWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectByteWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectCharWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectCharWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectDoubleWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectDoubleWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectFloatWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectFloatWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectIntWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectIntWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectLongWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectLongWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectShortWithTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectShortWithBagTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> flatCollectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> detectOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> min_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> max_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> minOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> maxOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> min_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> max_null_throws_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> min_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> max_null_safe;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> minByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> maxByOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> minBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> maxBy_null_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> detectWithOptional;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> getAny;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> getOnly;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> getOnly_not_only_one_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> getOnly_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> iterator_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> summarizeFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumFloatConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumFloatConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> summarizeDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumDoubleConsistentRounding1;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumDoubleConsistentRounding2;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> summarizeInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> summarizeLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumByInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumByFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumByFloatConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumByLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumByDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> sumByDoubleConsistentRounding;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> partitionWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toCollection;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedList_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedBag_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedListBy_with_null;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toMapTarget;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> toImmutableBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> fusedCollectMakeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> appendStringThrows;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> countBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> countByWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> countByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> groupByUniqueKey;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> groupByUniqueKey_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> groupByUniqueKey_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> groupByUniqueKey_target_throws_for_duplicate;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> chunk_empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> chunk_single;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> aggregateByNonMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractRichIterableTestCase> reduceOptional;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.testNewCollection = AbstractRichIterableTestCase::testNewCollection;
            this.payloads.equalsAndHashCode = AbstractRichIterableTestCase::equalsAndHashCode;
            this.payloads.contains = AbstractRichIterableTestCase::contains;
            this.payloads.containsBy = AbstractRichIterableTestCase::containsBy;
            this.payloads.containsAllIterable = AbstractRichIterableTestCase::containsAllIterable;
            this.payloads.containsAnyIterable = AbstractRichIterableTestCase::containsAnyIterable;
            this.payloads.containsNoneIterable = AbstractRichIterableTestCase::containsNoneIterable;
            this.payloads.containsAllArray = AbstractRichIterableTestCase::containsAllArray;
            this.payloads.containsAnyCollection = AbstractRichIterableTestCase::containsAnyCollection;
            this.payloads.containsNoneCollection = AbstractRichIterableTestCase::containsNoneCollection;
            this.payloads.containsAllCollection = AbstractRichIterableTestCase::containsAllCollection;
            this.payloads.tap = AbstractRichIterableTestCase::tap;
            this.payloads.forEach = AbstractRichIterableTestCase::forEach;
            this.payloads.forEachWith = AbstractRichIterableTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractRichIterableTestCase::forEachWithIndex;
            this.payloads.select = AbstractRichIterableTestCase::select;
            this.payloads.selectWith = AbstractRichIterableTestCase::selectWith;
            this.payloads.selectWith_target = AbstractRichIterableTestCase::selectWith_target;
            this.payloads.reject = AbstractRichIterableTestCase::reject;
            this.payloads.rejectWith = AbstractRichIterableTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractRichIterableTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractRichIterableTestCase::selectInstancesOf;
            this.payloads.collect = AbstractRichIterableTestCase::collect;
            this.payloads.collectTarget = AbstractRichIterableTestCase::collectTarget;
            this.payloads.collectBoolean = AbstractRichIterableTestCase::collectBoolean;
            this.payloads.collectBooleanWithTarget = AbstractRichIterableTestCase::collectBooleanWithTarget;
            this.payloads.collectBooleanWithBagTarget = AbstractRichIterableTestCase::collectBooleanWithBagTarget;
            this.payloads.collectByte = AbstractRichIterableTestCase::collectByte;
            this.payloads.collectByteWithTarget = AbstractRichIterableTestCase::collectByteWithTarget;
            this.payloads.collectByteWithBagTarget = AbstractRichIterableTestCase::collectByteWithBagTarget;
            this.payloads.collectChar = AbstractRichIterableTestCase::collectChar;
            this.payloads.collectCharWithTarget = AbstractRichIterableTestCase::collectCharWithTarget;
            this.payloads.collectCharWithBagTarget = AbstractRichIterableTestCase::collectCharWithBagTarget;
            this.payloads.collectDouble = AbstractRichIterableTestCase::collectDouble;
            this.payloads.collectDoubleWithTarget = AbstractRichIterableTestCase::collectDoubleWithTarget;
            this.payloads.collectDoubleWithBagTarget = AbstractRichIterableTestCase::collectDoubleWithBagTarget;
            this.payloads.collectFloat = AbstractRichIterableTestCase::collectFloat;
            this.payloads.collectFloatWithTarget = AbstractRichIterableTestCase::collectFloatWithTarget;
            this.payloads.collectFloatWithBagTarget = AbstractRichIterableTestCase::collectFloatWithBagTarget;
            this.payloads.collectInt = AbstractRichIterableTestCase::collectInt;
            this.payloads.collectIntWithTarget = AbstractRichIterableTestCase::collectIntWithTarget;
            this.payloads.collectIntWithBagTarget = AbstractRichIterableTestCase::collectIntWithBagTarget;
            this.payloads.collectLong = AbstractRichIterableTestCase::collectLong;
            this.payloads.collectLongWithTarget = AbstractRichIterableTestCase::collectLongWithTarget;
            this.payloads.collectLongWithBagTarget = AbstractRichIterableTestCase::collectLongWithBagTarget;
            this.payloads.collectShort = AbstractRichIterableTestCase::collectShort;
            this.payloads.collectShortWithTarget = AbstractRichIterableTestCase::collectShortWithTarget;
            this.payloads.collectShortWithBagTarget = AbstractRichIterableTestCase::collectShortWithBagTarget;
            this.payloads.flatCollect = AbstractRichIterableTestCase::flatCollect;
            this.payloads.flatCollectWith = AbstractRichIterableTestCase::flatCollectWith;
            this.payloads.flatCollectBoolean = AbstractRichIterableTestCase::flatCollectBoolean;
            this.payloads.flatCollectByte = AbstractRichIterableTestCase::flatCollectByte;
            this.payloads.flatCollectShort = AbstractRichIterableTestCase::flatCollectShort;
            this.payloads.flatCollectInt = AbstractRichIterableTestCase::flatCollectInt;
            this.payloads.flatCollectChar = AbstractRichIterableTestCase::flatCollectChar;
            this.payloads.flatCollectLong = AbstractRichIterableTestCase::flatCollectLong;
            this.payloads.flatCollectDouble = AbstractRichIterableTestCase::flatCollectDouble;
            this.payloads.flatCollectFloat = AbstractRichIterableTestCase::flatCollectFloat;
            this.payloads.detect = AbstractRichIterableTestCase::detect;
            this.payloads.detectOptional = AbstractRichIterableTestCase::detectOptional;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::min_null_throws, java.lang.NullPointerException.class);
            this.payloads.max_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::max_null_throws, java.lang.NullPointerException.class);
            this.payloads.min = AbstractRichIterableTestCase::min;
            this.payloads.minOptional = AbstractRichIterableTestCase::minOptional;
            this.payloads.max = AbstractRichIterableTestCase::max;
            this.payloads.maxOptional = AbstractRichIterableTestCase::maxOptional;
            this.payloads.min_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::min_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.max_null_throws_without_comparator = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::max_null_throws_without_comparator, java.lang.NullPointerException.class);
            this.payloads.min_without_comparator = AbstractRichIterableTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractRichIterableTestCase::max_without_comparator;
            this.payloads.min_null_safe = AbstractRichIterableTestCase::min_null_safe;
            this.payloads.max_null_safe = AbstractRichIterableTestCase::max_null_safe;
            this.payloads.minBy = AbstractRichIterableTestCase::minBy;
            this.payloads.minByOptional = AbstractRichIterableTestCase::minByOptional;
            this.payloads.maxBy = AbstractRichIterableTestCase::maxBy;
            this.payloads.maxByOptional = AbstractRichIterableTestCase::maxByOptional;
            this.payloads.minBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::minBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.maxBy_null_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::maxBy_null_throws, java.lang.NullPointerException.class);
            this.payloads.detectWith = AbstractRichIterableTestCase::detectWith;
            this.payloads.detectWithOptional = AbstractRichIterableTestCase::detectWithOptional;
            this.payloads.detectIfNone = AbstractRichIterableTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractRichIterableTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractRichIterableTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractRichIterableTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractRichIterableTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractRichIterableTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractRichIterableTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractRichIterableTestCase::anySatisfyWith;
            this.payloads.count = AbstractRichIterableTestCase::count;
            this.payloads.countWith = AbstractRichIterableTestCase::countWith;
            this.payloads.collectIf = AbstractRichIterableTestCase::collectIf;
            this.payloads.collectWith = AbstractRichIterableTestCase::collectWith;
            this.payloads.collectWith_target = AbstractRichIterableTestCase::collectWith_target;
            this.payloads.getAny = AbstractRichIterableTestCase::getAny;
            this.payloads.getFirst = AbstractRichIterableTestCase::getFirst;
            this.payloads.getLast = AbstractRichIterableTestCase::getLast;
            this.payloads.getOnly = AbstractRichIterableTestCase::getOnly;
            this.payloads.getOnly_not_only_one_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::getOnly_not_only_one_throws, java.lang.IllegalStateException.class);
            this.payloads.getOnly_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::getOnly_empty_throws, java.lang.IllegalStateException.class);
            this.payloads.isEmpty = AbstractRichIterableTestCase::isEmpty;
            this.payloads.iterator = AbstractRichIterableTestCase::iterator;
            this.payloads.iterator_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::iterator_throws, java.util.NoSuchElementException.class);
            this.payloads.injectInto = AbstractRichIterableTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractRichIterableTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractRichIterableTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractRichIterableTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractRichIterableTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractRichIterableTestCase::sumFloat;
            this.payloads.summarizeFloat = AbstractRichIterableTestCase::summarizeFloat;
            this.payloads.sumFloatConsistentRounding1 = AbstractRichIterableTestCase::sumFloatConsistentRounding1;
            this.payloads.sumFloatConsistentRounding2 = AbstractRichIterableTestCase::sumFloatConsistentRounding2;
            this.payloads.sumDouble = AbstractRichIterableTestCase::sumDouble;
            this.payloads.summarizeDouble = AbstractRichIterableTestCase::summarizeDouble;
            this.payloads.sumDoubleConsistentRounding1 = AbstractRichIterableTestCase::sumDoubleConsistentRounding1;
            this.payloads.sumDoubleConsistentRounding2 = AbstractRichIterableTestCase::sumDoubleConsistentRounding2;
            this.payloads.sumInteger = AbstractRichIterableTestCase::sumInteger;
            this.payloads.summarizeInt = AbstractRichIterableTestCase::summarizeInt;
            this.payloads.sumLong = AbstractRichIterableTestCase::sumLong;
            this.payloads.summarizeLong = AbstractRichIterableTestCase::summarizeLong;
            this.payloads.sumByInt = AbstractRichIterableTestCase::sumByInt;
            this.payloads.sumByFloat = AbstractRichIterableTestCase::sumByFloat;
            this.payloads.sumByFloatConsistentRounding = AbstractRichIterableTestCase::sumByFloatConsistentRounding;
            this.payloads.sumByLong = AbstractRichIterableTestCase::sumByLong;
            this.payloads.sumByDouble = AbstractRichIterableTestCase::sumByDouble;
            this.payloads.sumByDoubleConsistentRounding = AbstractRichIterableTestCase::sumByDoubleConsistentRounding;
            this.payloads.toArray = AbstractRichIterableTestCase::toArray;
            this.payloads.partition = AbstractRichIterableTestCase::partition;
            this.payloads.partitionWith = AbstractRichIterableTestCase::partitionWith;
            this.payloads.toList = AbstractRichIterableTestCase::toList;
            this.payloads.toImmutableList = AbstractRichIterableTestCase::toImmutableList;
            this.payloads.toCollection = AbstractRichIterableTestCase::toCollection;
            this.payloads.toBag = AbstractRichIterableTestCase::toBag;
            this.payloads.toImmutableBag = AbstractRichIterableTestCase::toImmutableBag;
            this.payloads.toSortedList_natural_ordering = AbstractRichIterableTestCase::toSortedList_natural_ordering;
            this.payloads.toImmutableSortedList_natural_ordering = AbstractRichIterableTestCase::toImmutableSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractRichIterableTestCase::toSortedList_with_comparator;
            this.payloads.toImmutableSortedList_with_comparator = AbstractRichIterableTestCase::toImmutableSortedList_with_comparator;
            this.payloads.toSortedList_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::toSortedList_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBag_natural_ordering = AbstractRichIterableTestCase::toSortedBag_natural_ordering;
            this.payloads.toImmutableSortedBag_natural_ordering = AbstractRichIterableTestCase::toImmutableSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractRichIterableTestCase::toSortedBag_with_comparator;
            this.payloads.toImmutableSortedBag_with_comparator = AbstractRichIterableTestCase::toImmutableSortedBag_with_comparator;
            this.payloads.toSortedBag_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::toSortedBag_with_null, java.lang.NullPointerException.class);
            this.payloads.toSortedBagBy = AbstractRichIterableTestCase::toSortedBagBy;
            this.payloads.toImmutableSortedBagBy = AbstractRichIterableTestCase::toImmutableSortedBagBy;
            this.payloads.toSortedListBy = AbstractRichIterableTestCase::toSortedListBy;
            this.payloads.toImmutableSortedListBy = AbstractRichIterableTestCase::toImmutableSortedListBy;
            this.payloads.toSortedSet_natural_ordering = AbstractRichIterableTestCase::toSortedSet_natural_ordering;
            this.payloads.toImmutableSortSet_natural_ordering = AbstractRichIterableTestCase::toImmutableSortSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractRichIterableTestCase::toSortedSet_with_comparator;
            this.payloads.toImmutableSortedSet_with_comparator = AbstractRichIterableTestCase::toImmutableSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractRichIterableTestCase::toSortedSetBy;
            this.payloads.toImmutableSortedSetBy = AbstractRichIterableTestCase::toImmutableSortedSetBy;
            this.payloads.toSortedListBy_with_null = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::toSortedListBy_with_null, java.lang.NullPointerException.class);
            this.payloads.toSet = AbstractRichIterableTestCase::toSet;
            this.payloads.toImmutableSet = AbstractRichIterableTestCase::toImmutableSet;
            this.payloads.toMap = AbstractRichIterableTestCase::toMap;
            this.payloads.toImmutableMap = AbstractRichIterableTestCase::toImmutableMap;
            this.payloads.toMapTarget = AbstractRichIterableTestCase::toMapTarget;
            this.payloads.toSortedMap = AbstractRichIterableTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractRichIterableTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractRichIterableTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractRichIterableTestCase::toBiMap;
            this.payloads.toImmutableBiMap = AbstractRichIterableTestCase::toImmutableBiMap;
            this.payloads.testToString = AbstractRichIterableTestCase::testToString;
            this.payloads.makeString = AbstractRichIterableTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractRichIterableTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractRichIterableTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.fusedCollectMakeString = AbstractRichIterableTestCase::fusedCollectMakeString;
            this.payloads.appendString = AbstractRichIterableTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractRichIterableTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractRichIterableTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.appendStringThrows = AbstractRichIterableTestCase::appendStringThrows;
            this.payloads.countBy = AbstractRichIterableTestCase::countBy;
            this.payloads.countByWith = AbstractRichIterableTestCase::countByWith;
            this.payloads.countByEach = AbstractRichIterableTestCase::countByEach;
            this.payloads.groupBy = AbstractRichIterableTestCase::groupBy;
            this.payloads.groupByEach = AbstractRichIterableTestCase::groupByEach;
            this.payloads.groupByUniqueKey = AbstractRichIterableTestCase::groupByUniqueKey;
            this.payloads.groupByUniqueKey_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::groupByUniqueKey_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.groupByUniqueKey_target = AbstractRichIterableTestCase::groupByUniqueKey_target;
            this.payloads.groupByUniqueKey_target_throws_for_duplicate = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::groupByUniqueKey_target_throws_for_duplicate, java.lang.IllegalStateException.class);
            this.payloads.zip = AbstractRichIterableTestCase::zip;
            this.payloads.zipWithIndex = AbstractRichIterableTestCase::zipWithIndex;
            this.payloads.chunk = AbstractRichIterableTestCase::chunk;
            this.payloads.chunk_empty = AbstractRichIterableTestCase::chunk_empty;
            this.payloads.chunk_single = AbstractRichIterableTestCase::chunk_single;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractRichIterableTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractRichIterableTestCase::chunk_large_size;
            this.payloads.empty = AbstractRichIterableTestCase::empty;
            this.payloads.notEmpty = AbstractRichIterableTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractRichIterableTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractRichIterableTestCase::aggregateByNonMutating;
            this.payloads.reduceOptional = AbstractRichIterableTestCase::reduceOptional;
        }
    }
}
