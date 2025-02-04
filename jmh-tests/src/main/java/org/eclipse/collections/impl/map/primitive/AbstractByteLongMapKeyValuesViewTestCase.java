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
import org.eclipse.collections.api.map.primitive.ByteLongMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ByteLongPair;
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
 * Abstract JUnit test for {@link ByteLongMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractByteLongMapKeyValuesViewTestCase {

    public abstract ByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2, byte key3, long value3);

    public abstract ByteLongMap newWithKeysValues(byte key1, long value1, byte key2, long value2);

    public abstract ByteLongMap newWithKeysValues(byte key1, long value1);

    public abstract ByteLongMap newEmpty();

    public RichIterable<ByteLongPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<ByteLongPair> newWith(byte key1, long value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<ByteLongPair> newWith(byte key1, long value1, byte key2, long value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<ByteLongPair> newWith(byte key1, long value1, byte key2, long value2, byte key3, long value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 1, 5L))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 1, 5L)));
    }

    @Test
    public void forEach() {
        MutableList<ByteLongPair> result = Lists.mutable.of();
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L));
        MutableList<ByteLongPair> result2 = Lists.mutable.of();
        RichIterable<ByteLongPair> collection2 = this.newWith((byte) 0, 2L, (byte) 2, 3L, (byte) 3, 4L);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((byte) 0, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L));
    }

    @Test
    public void forEachWith() {
        MutableBag<ByteLongPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 0L, (byte) 2, 3L, (byte) 3, 4L);
        collection.forEachWith((ByteLongPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 0L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<ByteLongPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<ByteLongPair> collection2 = this.newWith((byte) 2, 5L, (byte) 6, 3L, (byte) 3, 4L);
        collection2.forEachWith((ByteLongPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 2, 5L), PrimitiveTuples.pair((byte) 6, 3L), PrimitiveTuples.pair((byte) 3, 4L)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<ByteLongPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ByteLongPair> collection = this.newWith((byte) 2, 2L, (byte) 6, 3L, (byte) 3, 4L);
        collection.forEachWithIndex((ByteLongPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 2, 2L), PrimitiveTuples.pair((byte) 6, 3L), PrimitiveTuples.pair((byte) 3, 4L)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<ByteLongPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<ByteLongPair> collection2 = this.newWith((byte) 0, 1L, (byte) 2, 3L, (byte) 3, 4L);
        collection2.forEachWithIndex((ByteLongPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((byte) 0, 1L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<ByteLongPair> result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).select(PrimitiveTuples.pair((byte) 2, 3L)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4L), result);
    }

    @Test
    public void selectWith() {
        MutableList<ByteLongPair> result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).selectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4L), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<ByteLongPair> result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, 3L), HashBag.<ByteLongPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 3, 4L)), result);
    }

    @Test
    public void reject() {
        MutableList<ByteLongPair> result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).reject(Predicates.notEqual(PrimitiveTuples.pair((byte) 2, 3L))).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4L), result);
    }

    @Test
    public void rejectWith() {
        MutableList<ByteLongPair> result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((byte) 2, 3L)).toList();
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 1, 2L), result);
        Verify.assertNotContains(PrimitiveTuples.pair((byte) 3, 4L), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<ByteLongPair> result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).rejectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3L), HashBag.<ByteLongPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 3, 4L)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ByteLongPair.class), PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 3, 4L), PrimitiveTuples.pair((byte) 2, 3L));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collect((ByteLongPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collect((ByteLongPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectBoolean((ByteLongPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectByte((ByteLongPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectChar((ByteLongPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectDouble((ByteLongPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectFloat((ByteLongPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectInt((ByteLongPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectLong((ByteLongPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectShort((ByteLongPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Function<ByteLongPair, MutableList<String>> function = (ByteLongPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2", "2:3", "3:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2", "2:3", "3:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).detect(PrimitiveTuples.pair((byte) 2, 3L)::equals));
        Assert.assertNull(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).detect(PrimitiveTuples.pair((byte) 2, 4L)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, 4L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 3, 4L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).minBy((ByteLongPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 4, 5L).maxBy((ByteLongPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).detectWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3L)));
        Assert.assertNull(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<ByteLongPair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, 6L));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).detectIfNone(PrimitiveTuples.pair((byte) 2, 3L)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, 6L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<ByteLongPair> function = Functions0.value(PrimitiveTuples.pair((byte) 5, 6L));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 2, 3L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).detectWithIfNone(Object::equals, PrimitiveTuples.pair((byte) 2, 3L), function));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 5, 6L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).allSatisfy(ByteLongPair.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).allSatisfy(PrimitiveTuples.pair((byte) 2, 3L)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).allSatisfyWith(Predicates2.instanceOf(), ByteLongPair.class));
        Assert.assertFalse(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).allSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3L)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).noneSatisfy(PrimitiveTuples.pair((byte) 2, 3L)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3L)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).anySatisfy(PrimitiveTuples.pair((byte) 2, 3L)::equals));
        Assert.assertFalse(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).anySatisfy(PrimitiveTuples.pair((byte) 2, 5L)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3L)));
        Assert.assertFalse(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).anySatisfyWith(Object::equals, PrimitiveTuples.pair((byte) 2, 5L)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).count(ByteLongPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).count(PrimitiveTuples.pair((byte) 2, 3L)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).countWith(Predicates2.instanceOf(), ByteLongPair.class));
        Assert.assertEquals(1, this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).countWith(Object::equals, PrimitiveTuples.pair((byte) 2, 3L)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectIf(ByteLongPair.class::isInstance, String::valueOf), "1:2", "2:3", "3:4");
        Verify.assertContainsAll(this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectIf(ByteLongPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectWith((ByteLongPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).collectWith((ByteLongPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        ByteLongPair first = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, 2L).equals(first) || PrimitiveTuples.pair((byte) 2, 3L).equals(first) || PrimitiveTuples.pair((byte) 3, 4L).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2L), this.newWith((byte) 1, 2L).getFirst());
    }

    @Test
    public void getLast() {
        ByteLongPair last = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((byte) 1, 2L).equals(last) || PrimitiveTuples.pair((byte) 2, 3L).equals(last) || PrimitiveTuples.pair((byte) 3, 4L).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((byte) 1, 2L), this.newWith((byte) 1, 2L).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((byte) 1, 2L));
        Assert.assertTrue(this.newWith((byte) 1, 2L).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 0, 3L, (byte) 3, 4L);
        MutableBag<ByteLongPair> actual = Bags.mutable.of();
        Iterator<ByteLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 2, 3L, (byte) 4, 3L, (byte) 3, 4L);
        MutableBag<ByteLongPair> actual = Bags.mutable.of();
        Iterator<ByteLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Iterator<ByteLongPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Iterator<ByteLongPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Long result = objects.injectInto(1L, (Long argument1, ByteLongPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        int result = objects.injectInto(1, (int intParameter, ByteLongPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        long result = objects.injectInto(1L, (long parameter, ByteLongPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        double result = objects.injectInto(1.0, (double parameter, ByteLongPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        float result = objects.injectInto(1.0f, (float parameter, ByteLongPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        double actual = objects.sumOfFloat((ByteLongPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        double actual = objects.sumOfDouble((ByteLongPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        long actual = objects.sumOfInt((ByteLongPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        long actual = objects.sumOfLong((ByteLongPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<ByteLongPair> objects = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ByteLongPair[] array2 = objects.toArray(new ByteLongPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<ByteLongPair> result = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).partition(PrimitiveTuples.pair((byte) 2, 3L)::equals);
        Verify.assertContains(PrimitiveTuples.pair((byte) 2, 3L), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((byte) 1, 2L), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((byte) 3, 4L), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<ByteLongPair> list = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L));
    }

    @Test
    public void toBag() {
        MutableBag<ByteLongPair> bag = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableList<ByteLongPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableList<ByteLongPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 3, 4L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 1, 2L)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableList<ByteLongPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableSortedBag<ByteLongPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableSortedBag<ByteLongPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, 4L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 1, 2L)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableSortedBag<ByteLongPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableSortedSet<ByteLongPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableSortedSet<ByteLongPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((byte) 3, 4L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 1, 2L)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 2, 3L, (byte) 1, 2L, (byte) 3, 4L);
        MutableSortedSet<ByteLongPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L)), set);
    }

    @Test
    public void toSet() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        MutableSet<ByteLongPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((byte) 1, 2L), PrimitiveTuples.pair((byte) 2, 3L), PrimitiveTuples.pair((byte) 3, 4L));
    }

    @Test
    public void toMap() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<ByteLongPair> pairs = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString()) || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Function<ByteLongPair, Boolean> function = (ByteLongPair object) -> PrimitiveTuples.pair((byte) 1, 2L).equals(object);
        Multimap<Boolean, ByteLongPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, 4L)));
    }

    @Test
    public void groupByEach() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Function<ByteLongPair, MutableList<Boolean>> function = (ByteLongPair object) -> Lists.mutable.of(PrimitiveTuples.pair((byte) 1, 2L).equals(object));
        Multimap<Boolean, ByteLongPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((byte) 1, 2L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 2, 3L)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((byte) 3, 4L)));
    }

    @Test
    public void zip() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L);
        RichIterable<Pair<ByteLongPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, 2L), 1), Tuples.pair(PrimitiveTuples.pair((byte) 2, 3L), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, 3L), 1), Tuples.pair(PrimitiveTuples.pair((byte) 1, 2L), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L);
        RichIterable<Pair<ByteLongPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 1, 2L), 0), Tuples.pair(PrimitiveTuples.pair((byte) 2, 3L), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((byte) 2, 3L), 0), Tuples.pair(PrimitiveTuples.pair((byte) 1, 2L), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((byte) 1, 2L)), FastList.newListWith(PrimitiveTuples.pair((byte) 2, 3L)), FastList.newListWith(PrimitiveTuples.pair((byte) 3, 4L))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
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
        RichIterable<ByteLongPair> notEmpty = this.newWith((byte) 1, 2L);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ByteLongPair> sumAggregator = (AtomicInteger aggregate, ByteLongPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 2L, (byte) 2, 3L, (byte) 3, 4L);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ByteLongPair, Integer> sumAggregator = (Integer aggregate, ByteLongPair value) -> (int) (aggregate + value.getOne());
        RichIterable<ByteLongPair> collection = this.newWith((byte) 1, 1L, (byte) 1, 2L, (byte) 2, 3L);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractByteLongMapKeyValuesViewTestCase instance;

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllIterable);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.containsAllArray);
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
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.selectInstancesOf);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collect);
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
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.flatCollect);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.detect);
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
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.collectWith_target);
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
        public void benchmark_iterator_no_sentinels() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_no_sentinels);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_next_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_next_throws);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_throws() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.iterator_remove_throws);
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
        public void benchmark_toArray() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toArray);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.partition);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toList);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBag);
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
        public void benchmark_toSet() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toSet);
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
        public void benchmark_testToString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.testToString);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.makeString);
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
        public void benchmark_appendString() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.appendString);
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
        public void benchmark_chunk() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.chunk);
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
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByMutating);
        }

        //  @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.aggregateByNonMutating);
        }

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractByteLongMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractByteLongMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractByteLongMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractByteLongMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractByteLongMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractByteLongMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractByteLongMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractByteLongMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractByteLongMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractByteLongMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractByteLongMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractByteLongMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractByteLongMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractByteLongMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractByteLongMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractByteLongMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractByteLongMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractByteLongMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractByteLongMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractByteLongMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractByteLongMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractByteLongMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractByteLongMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractByteLongMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractByteLongMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractByteLongMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractByteLongMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractByteLongMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractByteLongMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractByteLongMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractByteLongMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractByteLongMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractByteLongMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractByteLongMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractByteLongMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractByteLongMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractByteLongMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractByteLongMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractByteLongMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractByteLongMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractByteLongMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractByteLongMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractByteLongMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractByteLongMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractByteLongMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractByteLongMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractByteLongMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractByteLongMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractByteLongMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractByteLongMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractByteLongMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractByteLongMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractByteLongMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractByteLongMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractByteLongMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractByteLongMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractByteLongMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractByteLongMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractByteLongMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractByteLongMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractByteLongMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractByteLongMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractByteLongMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractByteLongMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractByteLongMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractByteLongMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractByteLongMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractByteLongMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractByteLongMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractByteLongMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractByteLongMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractByteLongMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractByteLongMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractByteLongMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractByteLongMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractByteLongMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractByteLongMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractByteLongMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractByteLongMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractByteLongMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractByteLongMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractByteLongMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractByteLongMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractByteLongMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractByteLongMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractByteLongMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractByteLongMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractByteLongMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractByteLongMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractByteLongMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractByteLongMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractByteLongMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractByteLongMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractByteLongMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractByteLongMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
*/
}
