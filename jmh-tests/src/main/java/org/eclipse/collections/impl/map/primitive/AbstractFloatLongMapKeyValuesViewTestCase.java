/*
 * Copyright (c) 2022 Goldman Sachs and others.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * and Eclipse Distribution License v. 1.0 which accompany this distribution.
 * The Eclipse Public License is available at http://www.eclipse.org/legal/epl-v10.html
 * and the Eclipse Distribution License is available at
 * http://www.eclipse.org/org/documents/edl-v10.php.
 */
package org.eclipse.collections.impl.map.primitive;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.collections.api.BooleanIterable;
import org.eclipse.collections.api.ByteIterable;
import org.eclipse.collections.api.CharIterable;
import org.eclipse.collections.api.DoubleIterable;
import org.eclipse.collections.api.FloatIterable;
import org.eclipse.collections.api.IntIterable;
import org.eclipse.collections.api.LongIterable;
import org.eclipse.collections.api.RichIterable;
import org.eclipse.collections.api.ShortIterable;
import org.eclipse.collections.api.bag.MutableBag;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.impl.bag.sorted.mutable.TreeBag;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.FloatLongMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.FloatLongPair;
import org.eclipse.collections.impl.bag.mutable.HashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.BooleanHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ByteHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.CharHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.DoubleHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.FloatHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.IntHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.LongHashBag;
import org.eclipse.collections.impl.bag.mutable.primitive.ShortHashBag;
import org.eclipse.collections.impl.block.factory.Comparators;
import org.eclipse.collections.impl.block.factory.Functions0;
import org.eclipse.collections.impl.block.factory.Predicates;
import org.eclipse.collections.impl.block.factory.Predicates2;
import org.eclipse.collections.impl.block.procedure.CollectionAddProcedure;
import org.eclipse.collections.impl.factory.Bags;
import org.eclipse.collections.impl.factory.Lists;
import org.eclipse.collections.impl.list.Interval;
import org.eclipse.collections.impl.list.mutable.FastList;
import org.eclipse.collections.impl.map.mutable.UnifiedMap;
import org.eclipse.collections.impl.map.sorted.mutable.TreeSortedMap;
import org.eclipse.collections.impl.set.mutable.UnifiedSet;
import org.eclipse.collections.impl.set.sorted.mutable.TreeSortedSet;
import org.eclipse.collections.impl.test.Verify;
import org.eclipse.collections.impl.tuple.Tuples;
import org.eclipse.collections.impl.tuple.primitive.PrimitiveTuples;
import org.junit.Assert;
import org.junit.Test;

/**
 * Abstract JUnit test for {@link FloatLongMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractFloatLongMapKeyValuesViewTestCase {

    public abstract FloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2, float key3, long value3);

    public abstract FloatLongMap newWithKeysValues(float key1, long value1, float key2, long value2);

    public abstract FloatLongMap newWithKeysValues(float key1, long value1);

    public abstract FloatLongMap newEmpty();

    public RichIterable<FloatLongPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<FloatLongPair> newWith(float key1, long value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<FloatLongPair> newWith(float key1, long value1, float key2, long value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<FloatLongPair> newWith(float key1, long value1, float key2, long value2, float key3, long value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(1.0f, 5L))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(1.0f, 5L)));
    }

    @Test
    public void forEach() {
        MutableList<FloatLongPair> result = Lists.mutable.of();
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L));
        MutableList<FloatLongPair> result2 = Lists.mutable.of();
        RichIterable<FloatLongPair> collection2 = this.newWith(0.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L));
    }

    @Test
    public void forEachWith() {
        MutableBag<FloatLongPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 0L, 2.0f, 3L, 3.0f, 4L);
        collection.forEachWith((FloatLongPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, 0L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<FloatLongPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<FloatLongPair> collection2 = this.newWith(2.0f, 5L, 6.0f, 3L, 3.0f, 4L);
        collection2.forEachWith((FloatLongPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2.0f, 5L), PrimitiveTuples.pair(6.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<FloatLongPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<FloatLongPair> collection = this.newWith(2.0f, 2L, 6.0f, 3L, 3.0f, 4L);
        collection.forEachWithIndex((FloatLongPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2.0f, 2L), PrimitiveTuples.pair(6.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<FloatLongPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<FloatLongPair> collection2 = this.newWith(0.0f, 1L, 2.0f, 3L, 3.0f, 4L);
        collection2.forEachWithIndex((FloatLongPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0.0f, 1L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<FloatLongPair> result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).select(PrimitiveTuples.pair(2.0f, 3L)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, 4L), result);
    }

    @Test
    public void selectWith() {
        MutableList<FloatLongPair> result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).selectWith(Object::equals, PrimitiveTuples.pair(2.0f, 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, 4L), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<FloatLongPair> result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0f, 3L), HashBag.<FloatLongPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(3.0f, 4L)), result);
    }

    @Test
    public void reject() {
        MutableList<FloatLongPair> result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).reject(Predicates.notEqual(PrimitiveTuples.pair(2.0f, 3L))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, 4L), result);
    }

    @Test
    public void rejectWith() {
        MutableList<FloatLongPair> result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0f, 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0f, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0f, 4L), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<FloatLongPair> result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).rejectWith(Object::equals, PrimitiveTuples.pair(2.0f, 3L), HashBag.<FloatLongPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(3.0f, 4L)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<FloatLongPair> pairs = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(FloatLongPair.class), PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(3.0f, 4L), PrimitiveTuples.pair(2.0f, 3L));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collect((FloatLongPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collect((FloatLongPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectBoolean((FloatLongPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectByte((FloatLongPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectChar((FloatLongPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectDouble((FloatLongPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectFloat((FloatLongPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectInt((FloatLongPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectLong((FloatLongPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectShort((FloatLongPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Function<FloatLongPair, MutableList<String>> function = (FloatLongPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1.0:2", "2.0:3", "3.0:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1.0:2", "2.0:3", "3.0:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).detect(PrimitiveTuples.pair(2.0f, 3L)::equals));
        Assert.assertNull(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).detect(PrimitiveTuples.pair(2.0f, 4L)::equals));
    }

    @Test(expected = NoSuchElementException.class)
    public void min_empty_throws() {
        this.newWith().min(Comparators.naturalOrder());
    }

    @Test(expected = NoSuchElementException.class)
    public void max_empty_throws() {
        this.newWith().max(Comparators.naturalOrder());
    }

    @Test
    public void min() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0f, 4L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0f, 4L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).minBy((FloatLongPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2L), this.newWith(1.0f, 2L, 2.0f, 3L, 4.0f, 5L).maxBy((FloatLongPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).detectWith(Object::equals, PrimitiveTuples.pair(2.0f, 3L)));
        Assert.assertNull(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<FloatLongPair> function = Functions0.value(PrimitiveTuples.pair(5.0f, 6L));
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).detectIfNone(PrimitiveTuples.pair(2.0f, 3L)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0f, 6L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<FloatLongPair> function = Functions0.value(PrimitiveTuples.pair(5.0f, 6L));
        Assert.assertEquals(PrimitiveTuples.pair(2.0f, 3L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2.0f, 3L), function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0f, 6L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).allSatisfy(FloatLongPair.class::isInstance));
        Assert.assertFalse(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).allSatisfy(PrimitiveTuples.pair(2.0f, 3L)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).allSatisfyWith(Predicates2.instanceOf(), FloatLongPair.class));
        Assert.assertFalse(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, 3L)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).noneSatisfy(PrimitiveTuples.pair(2.0f, 3L)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, 3L)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).anySatisfy(PrimitiveTuples.pair(2.0f, 3L)::equals));
        Assert.assertFalse(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).anySatisfy(PrimitiveTuples.pair(2.0f, 5L)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, 3L)));
        Assert.assertFalse(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0f, 5L)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).count(FloatLongPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).count(PrimitiveTuples.pair(2.0f, 3L)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).countWith(Predicates2.instanceOf(), FloatLongPair.class));
        Assert.assertEquals(1, this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).countWith(Object::equals, PrimitiveTuples.pair(2.0f, 3L)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectIf(FloatLongPair.class::isInstance, String::valueOf), "1.0:2", "2.0:3", "3.0:4");
        Verify.assertContainsAll(this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectIf(FloatLongPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1.0:2", "2.0:3", "3.0:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectWith((FloatLongPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).collectWith((FloatLongPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        FloatLongPair first = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1.0f, 2L).equals(first) || PrimitiveTuples.pair(2.0f, 3L).equals(first) || PrimitiveTuples.pair(3.0f, 4L).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2L), this.newWith(1.0f, 2L).getFirst());
    }

    @Test
    public void getLast() {
        FloatLongPair last = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1.0f, 2L).equals(last) || PrimitiveTuples.pair(2.0f, 3L).equals(last) || PrimitiveTuples.pair(3.0f, 4L).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1.0f, 2L), this.newWith(1.0f, 2L).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1.0f, 2L));
        Assert.assertTrue(this.newWith(1.0f, 2L).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 0.0f, 3L, 3.0f, 4L);
        MutableBag<FloatLongPair> actual = Bags.mutable.of();
        Iterator<FloatLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<FloatLongPair> objects = this.newWith(2.0f, 3L, 4.0f, 3L, 3.0f, 4L);
        MutableBag<FloatLongPair> actual = Bags.mutable.of();
        Iterator<FloatLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Iterator<FloatLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Iterator<FloatLongPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Long result = objects.injectInto(1L, (Long argument1, FloatLongPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        int result = objects.injectInto(1, (int intParameter, FloatLongPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        long result = objects.injectInto(1L, (long parameter, FloatLongPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        double result = objects.injectInto(1.0, (double parameter, FloatLongPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        float result = objects.injectInto(1.0f, (float parameter, FloatLongPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        double actual = objects.sumOfFloat((FloatLongPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        double actual = objects.sumOfDouble((FloatLongPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        long actual = objects.sumOfInt((FloatLongPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        long actual = objects.sumOfLong((FloatLongPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<FloatLongPair> objects = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        FloatLongPair[] array2 = objects.toArray(new FloatLongPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<FloatLongPair> result = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).partition(PrimitiveTuples.pair(2.0f, 3L)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2.0f, 3L), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1.0f, 2L), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3.0f, 4L), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<FloatLongPair> list = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L));
    }

    @Test
    public void toBag() {
        MutableBag<FloatLongPair> bag = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableList<FloatLongPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableList<FloatLongPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3.0f, 4L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(1.0f, 2L)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableList<FloatLongPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableSortedBag<FloatLongPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableSortedBag<FloatLongPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0f, 4L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(1.0f, 2L)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableSortedBag<FloatLongPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableSortedSet<FloatLongPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableSortedSet<FloatLongPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0f, 4L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(1.0f, 2L)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<FloatLongPair> pairs = this.newWith(2.0f, 3L, 1.0f, 2L, 3.0f, 4L);
        MutableSortedSet<FloatLongPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L)), set);
    }

    @Test
    public void toSet() {
        RichIterable<FloatLongPair> pairs = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        MutableSet<FloatLongPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1.0f, 2L), PrimitiveTuples.pair(2.0f, 3L), PrimitiveTuples.pair(3.0f, 4L));
    }

    @Test
    public void toMap() {
        RichIterable<FloatLongPair> pairs = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<FloatLongPair> pairs = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<FloatLongPair> pairs = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<FloatLongPair> pairs = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L);
        Assert.assertTrue("[1.0:2, 2.0:3]".equals(collection.toString()) || "[2.0:3, 1.0:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Function<FloatLongPair, Boolean> function = (FloatLongPair object) -> PrimitiveTuples.pair(1.0f, 2L).equals(object);
        Multimap<Boolean, FloatLongPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0f, 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0f, 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0f, 4L)));
    }

    @Test
    public void groupByEach() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Function<FloatLongPair, MutableList<Boolean>> function = (FloatLongPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1.0f, 2L).equals(object));
        Multimap<Boolean, FloatLongPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0f, 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0f, 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0f, 4L)));
    }

    @Test
    public void zip() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L);
        RichIterable<Pair<FloatLongPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0f, 2L), 1), Tuples.pair(PrimitiveTuples.pair(2.0f, 3L), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0f, 3L), 1), Tuples.pair(PrimitiveTuples.pair(1.0f, 2L), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L);
        RichIterable<Pair<FloatLongPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0f, 2L), 0), Tuples.pair(PrimitiveTuples.pair(2.0f, 3L), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0f, 3L), 0), Tuples.pair(PrimitiveTuples.pair(1.0f, 2L), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1.0f, 2L)), FastList.newListWith(PrimitiveTuples.pair(2.0f, 3L)), FastList.newListWith(PrimitiveTuples.pair(3.0f, 4L))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        Verify.assertIterableSize(3, collection.chunk(10).getFirst());
    }

    @Test
    public void empty() {
        Verify.assertIterableEmpty(this.newWith());
        Assert.assertTrue(this.newWith().isEmpty());
        Assert.assertFalse(this.newWith().notEmpty());
    }

    @Test
    public void notEmpty() {
        RichIterable<FloatLongPair> notEmpty = this.newWith(1.0f, 2L);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, FloatLongPair> sumAggregator = (AtomicInteger aggregate, FloatLongPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 2L, 2.0f, 3L, 3.0f, 4L);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3.0:4").intValue());
        Assert.assertEquals(2, aggregation.get("2.0:3").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, FloatLongPair, Integer> sumAggregator = (Integer aggregate, FloatLongPair value) -> (int) (aggregate + value.getOne());
        RichIterable<FloatLongPair> collection = this.newWith(1.0f, 1L, 1.0f, 2L, 2.0f, 3L);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2.0:3").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractFloatLongMapKeyValuesViewTestCase instance;

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detectWith);
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
        public void benchmark_iterator_no_sentinels() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_no_sentinels);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_next_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_next_throws);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_throws);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedList_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedListBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBag_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedBagBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_natural_ordering);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSet_with_comparator);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSortedSetBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toMap);
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
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupBy);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.groupByEach);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractFloatLongMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractFloatLongMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractFloatLongMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractFloatLongMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractFloatLongMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractFloatLongMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractFloatLongMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractFloatLongMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractFloatLongMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractFloatLongMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractFloatLongMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractFloatLongMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractFloatLongMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractFloatLongMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractFloatLongMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractFloatLongMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractFloatLongMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractFloatLongMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractFloatLongMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractFloatLongMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractFloatLongMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractFloatLongMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractFloatLongMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractFloatLongMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractFloatLongMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatLongMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatLongMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractFloatLongMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractFloatLongMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractFloatLongMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractFloatLongMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractFloatLongMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractFloatLongMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractFloatLongMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractFloatLongMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractFloatLongMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractFloatLongMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractFloatLongMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractFloatLongMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractFloatLongMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractFloatLongMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractFloatLongMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractFloatLongMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractFloatLongMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractFloatLongMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractFloatLongMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractFloatLongMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractFloatLongMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractFloatLongMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractFloatLongMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractFloatLongMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractFloatLongMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatLongMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatLongMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractFloatLongMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractFloatLongMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractFloatLongMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractFloatLongMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractFloatLongMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractFloatLongMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractFloatLongMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractFloatLongMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractFloatLongMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractFloatLongMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractFloatLongMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractFloatLongMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractFloatLongMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractFloatLongMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractFloatLongMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractFloatLongMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractFloatLongMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractFloatLongMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractFloatLongMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractFloatLongMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractFloatLongMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractFloatLongMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractFloatLongMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractFloatLongMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractFloatLongMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractFloatLongMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractFloatLongMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractFloatLongMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractFloatLongMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractFloatLongMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractFloatLongMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractFloatLongMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractFloatLongMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractFloatLongMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractFloatLongMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractFloatLongMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractFloatLongMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractFloatLongMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractFloatLongMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractFloatLongMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractFloatLongMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractFloatLongMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractFloatLongMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractFloatLongMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractFloatLongMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
