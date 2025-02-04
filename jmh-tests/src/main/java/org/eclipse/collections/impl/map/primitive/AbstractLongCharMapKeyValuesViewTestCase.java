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
import org.eclipse.collections.api.map.primitive.LongCharMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.LongCharPair;
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
 * Abstract JUnit test for {@link LongCharMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractLongCharMapKeyValuesViewTestCase {

    public abstract LongCharMap newWithKeysValues(long key1, char value1, long key2, char value2, long key3, char value3);

    public abstract LongCharMap newWithKeysValues(long key1, char value1, long key2, char value2);

    public abstract LongCharMap newWithKeysValues(long key1, char value1);

    public abstract LongCharMap newEmpty();

    public RichIterable<LongCharPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<LongCharPair> newWith(long key1, char value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<LongCharPair> newWith(long key1, char value1, long key2, char value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<LongCharPair> newWith(long key1, char value1, long key2, char value2, long key3, char value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(1L, (char) 5))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(1L, (char) 5)));
    }

    @Test
    public void forEach() {
        MutableList<LongCharPair> result = Lists.mutable.of();
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4));
        MutableList<LongCharPair> result2 = Lists.mutable.of();
        RichIterable<LongCharPair> collection2 = this.newWith(0L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4));
    }

    @Test
    public void forEachWith() {
        MutableBag<LongCharPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 0, 2L, (char) 3, 3L, (char) 4);
        collection.forEachWith((LongCharPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, (char) 0), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<LongCharPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<LongCharPair> collection2 = this.newWith(2L, (char) 5, 6L, (char) 3, 3L, (char) 4);
        collection2.forEachWith((LongCharPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2L, (char) 5), PrimitiveTuples.pair(6L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<LongCharPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<LongCharPair> collection = this.newWith(2L, (char) 2, 6L, (char) 3, 3L, (char) 4);
        collection.forEachWithIndex((LongCharPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2L, (char) 2), PrimitiveTuples.pair(6L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<LongCharPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<LongCharPair> collection2 = this.newWith(0L, (char) 1, 2L, (char) 3, 3L, (char) 4);
        collection2.forEachWithIndex((LongCharPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0L, (char) 1), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<LongCharPair> result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).select(PrimitiveTuples.pair(2L, (char) 3)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, (char) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, (char) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, (char) 4), result);
    }

    @Test
    public void selectWith() {
        MutableList<LongCharPair> result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).selectWith(Object::equals, PrimitiveTuples.pair(2L, (char) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, (char) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, (char) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, (char) 4), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<LongCharPair> result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, (char) 3), HashBag.<LongCharPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(3L, (char) 4)), result);
    }

    @Test
    public void reject() {
        MutableList<LongCharPair> result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).reject(Predicates.notEqual(PrimitiveTuples.pair(2L, (char) 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, (char) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, (char) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, (char) 4), result);
    }

    @Test
    public void rejectWith() {
        MutableList<LongCharPair> result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, (char) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, (char) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, (char) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, (char) 4), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<LongCharPair> result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).rejectWith(Object::equals, PrimitiveTuples.pair(2L, (char) 3), HashBag.<LongCharPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(3L, (char) 4)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<LongCharPair> pairs = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(LongCharPair.class), PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(3L, (char) 4), PrimitiveTuples.pair(2L, (char) 3));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collect((LongCharPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collect((LongCharPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectBoolean((LongCharPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectByte((LongCharPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectChar((LongCharPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectDouble((LongCharPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectFloat((LongCharPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectInt((LongCharPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectLong((LongCharPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectShort((LongCharPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Function<LongCharPair, MutableList<String>> function = (LongCharPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:\u0002", "2:\u0003", "3:\u0004"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:\u0002", "2:\u0003", "3:\u0004"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, (char) 3), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).detect(PrimitiveTuples.pair(2L, (char) 3)::equals));
        Assert.assertNull(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).detect(PrimitiveTuples.pair(2L, (char) 4)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1L, (char) 2), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3L, (char) 4), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1L, (char) 2), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3L, (char) 4), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, (char) 3), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).minBy((LongCharPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1L, (char) 2), this.newWith(1L, (char) 2, 2L, (char) 3, 4L, (char) 5).maxBy((LongCharPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, (char) 3), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).detectWith(Object::equals, PrimitiveTuples.pair(2L, (char) 3)));
        Assert.assertNull(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<LongCharPair> function = Functions0.value(PrimitiveTuples.pair(5L, (char) 6));
        Assert.assertEquals(PrimitiveTuples.pair(2L, (char) 3), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).detectIfNone(PrimitiveTuples.pair(2L, (char) 3)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, (char) 6), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<LongCharPair> function = Functions0.value(PrimitiveTuples.pair(5L, (char) 6));
        Assert.assertEquals(PrimitiveTuples.pair(2L, (char) 3), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2L, (char) 3), function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, (char) 6), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).allSatisfy(LongCharPair.class::isInstance));
        Assert.assertFalse(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).allSatisfy(PrimitiveTuples.pair(2L, (char) 3)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).allSatisfyWith(Predicates2.instanceOf(), LongCharPair.class));
        Assert.assertFalse(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, (char) 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).noneSatisfy(PrimitiveTuples.pair(2L, (char) 3)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, (char) 3)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).anySatisfy(PrimitiveTuples.pair(2L, (char) 3)::equals));
        Assert.assertFalse(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).anySatisfy(PrimitiveTuples.pair(2L, (char) 5)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, (char) 3)));
        Assert.assertFalse(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, (char) 5)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).count(LongCharPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).count(PrimitiveTuples.pair(2L, (char) 3)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).countWith(Predicates2.instanceOf(), LongCharPair.class));
        Assert.assertEquals(1, this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).countWith(Object::equals, PrimitiveTuples.pair(2L, (char) 3)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectIf(LongCharPair.class::isInstance, String::valueOf), "1:\u0002", "2:\u0003", "3:\u0004");
        Verify.assertContainsAll(this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectIf(LongCharPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:\u0002", "2:\u0003", "3:\u0004");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectWith((LongCharPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).collectWith((LongCharPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        LongCharPair first = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1L, (char) 2).equals(first) || PrimitiveTuples.pair(2L, (char) 3).equals(first) || PrimitiveTuples.pair(3L, (char) 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1L, (char) 2), this.newWith(1L, (char) 2).getFirst());
    }

    @Test
    public void getLast() {
        LongCharPair last = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1L, (char) 2).equals(last) || PrimitiveTuples.pair(2L, (char) 3).equals(last) || PrimitiveTuples.pair(3L, (char) 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1L, (char) 2), this.newWith(1L, (char) 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1L, (char) 2));
        Assert.assertTrue(this.newWith(1L, (char) 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 0L, (char) 3, 3L, (char) 4);
        MutableBag<LongCharPair> actual = Bags.mutable.of();
        Iterator<LongCharPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<LongCharPair> objects = this.newWith(2L, (char) 3, 4L, (char) 3, 3L, (char) 4);
        MutableBag<LongCharPair> actual = Bags.mutable.of();
        Iterator<LongCharPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Iterator<LongCharPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Iterator<LongCharPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Long result = objects.injectInto(1L, (Long argument1, LongCharPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        int result = objects.injectInto(1, (int intParameter, LongCharPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        long result = objects.injectInto(1L, (long parameter, LongCharPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        double result = objects.injectInto(1.0, (double parameter, LongCharPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        float result = objects.injectInto(1.0f, (float parameter, LongCharPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        double actual = objects.sumOfFloat((LongCharPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        double actual = objects.sumOfDouble((LongCharPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        long actual = objects.sumOfInt((LongCharPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        long actual = objects.sumOfLong((LongCharPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<LongCharPair> objects = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        LongCharPair[] array2 = objects.toArray(new LongCharPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<LongCharPair> result = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).partition(PrimitiveTuples.pair(2L, (char) 3)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2L, (char) 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1L, (char) 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3L, (char) 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<LongCharPair> list = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4));
    }

    @Test
    public void toBag() {
        MutableBag<LongCharPair> bag = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableList<LongCharPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableList<LongCharPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3L, (char) 4), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(1L, (char) 2)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableList<LongCharPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableSortedBag<LongCharPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableSortedBag<LongCharPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, (char) 4), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(1L, (char) 2)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableSortedBag<LongCharPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableSortedSet<LongCharPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableSortedSet<LongCharPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, (char) 4), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(1L, (char) 2)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<LongCharPair> pairs = this.newWith(2L, (char) 3, 1L, (char) 2, 3L, (char) 4);
        MutableSortedSet<LongCharPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4)), set);
    }

    @Test
    public void toSet() {
        RichIterable<LongCharPair> pairs = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        MutableSet<LongCharPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1L, (char) 2), PrimitiveTuples.pair(2L, (char) 3), PrimitiveTuples.pair(3L, (char) 4));
    }

    @Test
    public void toMap() {
        RichIterable<LongCharPair> pairs = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:\u0002", "1:\u0002", "2:\u0003", "2:\u0003", "3:\u0004", "3:\u0004"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<LongCharPair> pairs = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:\u0002", "1:\u0002", "2:\u0003", "2:\u0003", "3:\u0004", "3:\u0004"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<LongCharPair> pairs = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:\u0002", "1:\u0002", "2:\u0003", "2:\u0003", "3:\u0004", "3:\u0004"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<LongCharPair> pairs = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:\u0002", "1:\u0002", "2:\u0003", "2:\u0003", "3:\u0004", "3:\u0004"), map);
    }

    @Test
    public void testToString() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3);
        Assert.assertTrue("[1:\u0002, 2:\u0003]".equals(collection.toString()) || "[2:\u0003, 1:\u0002]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Function<LongCharPair, Boolean> function = (LongCharPair object) -> PrimitiveTuples.pair(1L, (char) 2).equals(object);
        Multimap<Boolean, LongCharPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, (char) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, (char) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, (char) 4)));
    }

    @Test
    public void groupByEach() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Function<LongCharPair, MutableList<Boolean>> function = (LongCharPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1L, (char) 2).equals(object));
        Multimap<Boolean, LongCharPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, (char) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, (char) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, (char) 4)));
    }

    @Test
    public void zip() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3);
        RichIterable<Pair<LongCharPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, (char) 2), 1), Tuples.pair(PrimitiveTuples.pair(2L, (char) 3), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, (char) 3), 1), Tuples.pair(PrimitiveTuples.pair(1L, (char) 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3);
        RichIterable<Pair<LongCharPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, (char) 2), 0), Tuples.pair(PrimitiveTuples.pair(2L, (char) 3), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, (char) 3), 0), Tuples.pair(PrimitiveTuples.pair(1L, (char) 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1L, (char) 2)), FastList.newListWith(PrimitiveTuples.pair(2L, (char) 3)), FastList.newListWith(PrimitiveTuples.pair(3L, (char) 4))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
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
        RichIterable<LongCharPair> notEmpty = this.newWith(1L, (char) 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, LongCharPair> sumAggregator = (AtomicInteger aggregate, LongCharPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 2, 2L, (char) 3, 3L, (char) 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:\u0004").intValue());
        Assert.assertEquals(2, aggregation.get("2:\u0003").intValue());
        Assert.assertEquals(1, aggregation.get("1:\u0002").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, LongCharPair, Integer> sumAggregator = (Integer aggregate, LongCharPair value) -> (int) (aggregate + value.getOne());
        RichIterable<LongCharPair> collection = this.newWith(1L, (char) 1, 1L, (char) 2, 2L, (char) 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:\u0003").intValue());
        Assert.assertEquals(1, aggregation.get("1:\u0002").intValue());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLongCharMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLongCharMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongCharMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractLongCharMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractLongCharMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractLongCharMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractLongCharMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractLongCharMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractLongCharMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractLongCharMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractLongCharMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractLongCharMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractLongCharMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractLongCharMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractLongCharMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractLongCharMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractLongCharMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractLongCharMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractLongCharMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractLongCharMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractLongCharMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractLongCharMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractLongCharMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractLongCharMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractLongCharMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractLongCharMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractLongCharMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractLongCharMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractLongCharMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractLongCharMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractLongCharMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractLongCharMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractLongCharMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractLongCharMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractLongCharMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractLongCharMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractLongCharMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractLongCharMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractLongCharMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractLongCharMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractLongCharMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractLongCharMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractLongCharMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractLongCharMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractLongCharMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractLongCharMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractLongCharMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractLongCharMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractLongCharMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractLongCharMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractLongCharMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractLongCharMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractLongCharMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractLongCharMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractLongCharMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractLongCharMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractLongCharMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractLongCharMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractLongCharMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractLongCharMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractLongCharMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractLongCharMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractLongCharMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractLongCharMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractLongCharMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractLongCharMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractLongCharMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractLongCharMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractLongCharMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractLongCharMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractLongCharMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractLongCharMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractLongCharMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractLongCharMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractLongCharMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractLongCharMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractLongCharMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractLongCharMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractLongCharMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractLongCharMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractLongCharMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractLongCharMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractLongCharMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractLongCharMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractLongCharMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractLongCharMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractLongCharMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractLongCharMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractLongCharMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractLongCharMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongCharMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractLongCharMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractLongCharMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractLongCharMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractLongCharMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractLongCharMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
*/
}
