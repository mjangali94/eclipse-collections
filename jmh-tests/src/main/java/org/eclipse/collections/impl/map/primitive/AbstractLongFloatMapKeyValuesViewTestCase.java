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
import org.eclipse.collections.api.map.primitive.LongFloatMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.LongFloatPair;
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
 * Abstract JUnit test for {@link LongFloatMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractLongFloatMapKeyValuesViewTestCase {

    public abstract LongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2, long key3, float value3);

    public abstract LongFloatMap newWithKeysValues(long key1, float value1, long key2, float value2);

    public abstract LongFloatMap newWithKeysValues(long key1, float value1);

    public abstract LongFloatMap newEmpty();

    public RichIterable<LongFloatPair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<LongFloatPair> newWith(long key1, float value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<LongFloatPair> newWith(long key1, float value1, long key2, float value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<LongFloatPair> newWith(long key1, float value1, long key2, float value2, long key3, float value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(1L, 5.0f))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(1L, 5.0f)));
    }

    @Test
    public void forEach() {
        MutableList<LongFloatPair> result = Lists.mutable.of();
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f));
        MutableList<LongFloatPair> result2 = Lists.mutable.of();
        RichIterable<LongFloatPair> collection2 = this.newWith(0L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f));
    }

    @Test
    public void forEachWith() {
        MutableBag<LongFloatPair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<LongFloatPair> collection = this.newWith(1L, 0.0f, 2L, 3.0f, 3L, 4.0f);
        collection.forEachWith((LongFloatPair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 0.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<LongFloatPair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<LongFloatPair> collection2 = this.newWith(2L, 5.0f, 6L, 3.0f, 3L, 4.0f);
        collection2.forEachWith((LongFloatPair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2L, 5.0f), PrimitiveTuples.pair(6L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<LongFloatPair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<LongFloatPair> collection = this.newWith(2L, 2.0f, 6L, 3.0f, 3L, 4.0f);
        collection.forEachWithIndex((LongFloatPair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2L, 2.0f), PrimitiveTuples.pair(6L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<LongFloatPair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<LongFloatPair> collection2 = this.newWith(0L, 1.0f, 2L, 3.0f, 3L, 4.0f);
        collection2.forEachWithIndex((LongFloatPair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0L, 1.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<LongFloatPair> result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).select(PrimitiveTuples.pair(2L, 3.0f)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4.0f), result);
    }

    @Test
    public void selectWith() {
        MutableList<LongFloatPair> result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).selectWith(Object::equals, PrimitiveTuples.pair(2L, 3.0f)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4.0f), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<LongFloatPair> result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, 3.0f), HashBag.<LongFloatPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(3L, 4.0f)), result);
    }

    @Test
    public void reject() {
        MutableList<LongFloatPair> result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).reject(Predicates.notEqual(PrimitiveTuples.pair(2L, 3.0f))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4.0f), result);
    }

    @Test
    public void rejectWith() {
        MutableList<LongFloatPair> result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, 3.0f)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, 2.0f), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, 4.0f), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<LongFloatPair> result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).rejectWith(Object::equals, PrimitiveTuples.pair(2L, 3.0f), HashBag.<LongFloatPair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(3L, 4.0f)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<LongFloatPair> pairs = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(LongFloatPair.class), PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(3L, 4.0f), PrimitiveTuples.pair(2L, 3.0f));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collect((LongFloatPair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collect((LongFloatPair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectBoolean((LongFloatPair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectByte((LongFloatPair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectChar((LongFloatPair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectDouble((LongFloatPair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectFloat((LongFloatPair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectInt((LongFloatPair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectLong((LongFloatPair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectShort((LongFloatPair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Function<LongFloatPair, MutableList<String>> function = (LongFloatPair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2.0", "2:3.0", "3:4.0"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2.0", "2:3.0", "3:4.0"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).detect(PrimitiveTuples.pair(2L, 3.0f)::equals));
        Assert.assertNull(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).detect(PrimitiveTuples.pair(2L, 4.0f)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3L, 4.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3L, 4.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).minBy((LongFloatPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 4L, 5.0f).maxBy((LongFloatPair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).detectWith(Object::equals, PrimitiveTuples.pair(2L, 3.0f)));
        Assert.assertNull(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<LongFloatPair> function = Functions0.value(PrimitiveTuples.pair(5L, 6.0f));
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).detectIfNone(PrimitiveTuples.pair(2L, 3.0f)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, 6.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<LongFloatPair> function = Functions0.value(PrimitiveTuples.pair(5L, 6.0f));
        Assert.assertEquals(PrimitiveTuples.pair(2L, 3.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2L, 3.0f), function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, 6.0f), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).allSatisfy(LongFloatPair.class::isInstance));
        Assert.assertFalse(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).allSatisfy(PrimitiveTuples.pair(2L, 3.0f)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).allSatisfyWith(Predicates2.instanceOf(), LongFloatPair.class));
        Assert.assertFalse(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3.0f)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).noneSatisfy(PrimitiveTuples.pair(2L, 3.0f)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3.0f)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).anySatisfy(PrimitiveTuples.pair(2L, 3.0f)::equals));
        Assert.assertFalse(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).anySatisfy(PrimitiveTuples.pair(2L, 5.0f)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 3.0f)));
        Assert.assertFalse(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, 5.0f)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).count(LongFloatPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).count(PrimitiveTuples.pair(2L, 3.0f)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).countWith(Predicates2.instanceOf(), LongFloatPair.class));
        Assert.assertEquals(1, this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).countWith(Object::equals, PrimitiveTuples.pair(2L, 3.0f)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectIf(LongFloatPair.class::isInstance, String::valueOf), "1:2.0", "2:3.0", "3:4.0");
        Verify.assertContainsAll(this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectIf(LongFloatPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2.0", "2:3.0", "3:4.0");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectWith((LongFloatPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).collectWith((LongFloatPair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        LongFloatPair first = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1L, 2.0f).equals(first) || PrimitiveTuples.pair(2L, 3.0f).equals(first) || PrimitiveTuples.pair(3L, 4.0f).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0f), this.newWith(1L, 2.0f).getFirst());
    }

    @Test
    public void getLast() {
        LongFloatPair last = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1L, 2.0f).equals(last) || PrimitiveTuples.pair(2L, 3.0f).equals(last) || PrimitiveTuples.pair(3L, 4.0f).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1L, 2.0f), this.newWith(1L, 2.0f).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1L, 2.0f));
        Assert.assertTrue(this.newWith(1L, 2.0f).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 0L, 3.0f, 3L, 4.0f);
        MutableBag<LongFloatPair> actual = Bags.mutable.of();
        Iterator<LongFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<LongFloatPair> objects = this.newWith(2L, 3.0f, 4L, 3.0f, 3L, 4.0f);
        MutableBag<LongFloatPair> actual = Bags.mutable.of();
        Iterator<LongFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Iterator<LongFloatPair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Iterator<LongFloatPair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Long result = objects.injectInto(1L, (Long argument1, LongFloatPair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        int result = objects.injectInto(1, (int intParameter, LongFloatPair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        long result = objects.injectInto(1L, (long parameter, LongFloatPair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        double result = objects.injectInto(1.0, (double parameter, LongFloatPair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        float result = objects.injectInto(1.0f, (float parameter, LongFloatPair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        double actual = objects.sumOfFloat((LongFloatPair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        double actual = objects.sumOfDouble((LongFloatPair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        long actual = objects.sumOfInt((LongFloatPair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        long actual = objects.sumOfLong((LongFloatPair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<LongFloatPair> objects = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        LongFloatPair[] array2 = objects.toArray(new LongFloatPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<LongFloatPair> result = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).partition(PrimitiveTuples.pair(2L, 3.0f)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2L, 3.0f), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1L, 2.0f), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3L, 4.0f), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<LongFloatPair> list = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f));
    }

    @Test
    public void toBag() {
        MutableBag<LongFloatPair> bag = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableList<LongFloatPair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableList<LongFloatPair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3L, 4.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(1L, 2.0f)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableList<LongFloatPair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableSortedBag<LongFloatPair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableSortedBag<LongFloatPair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, 4.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(1L, 2.0f)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableSortedBag<LongFloatPair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableSortedSet<LongFloatPair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableSortedSet<LongFloatPair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, 4.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(1L, 2.0f)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<LongFloatPair> pairs = this.newWith(2L, 3.0f, 1L, 2.0f, 3L, 4.0f);
        MutableSortedSet<LongFloatPair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f)), set);
    }

    @Test
    public void toSet() {
        RichIterable<LongFloatPair> pairs = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        MutableSet<LongFloatPair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1L, 2.0f), PrimitiveTuples.pair(2L, 3.0f), PrimitiveTuples.pair(3L, 4.0f));
    }

    @Test
    public void toMap() {
        RichIterable<LongFloatPair> pairs = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<LongFloatPair> pairs = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<LongFloatPair> pairs = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<LongFloatPair> pairs = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2.0", "1:2.0", "2:3.0", "2:3.0", "3:4.0", "3:4.0"), map);
    }

    @Test
    public void testToString() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f);
        Assert.assertTrue("[1:2.0, 2:3.0]".equals(collection.toString()) || "[2:3.0, 1:2.0]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Function<LongFloatPair, Boolean> function = (LongFloatPair object) -> PrimitiveTuples.pair(1L, 2.0f).equals(object);
        Multimap<Boolean, LongFloatPair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, 2.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, 3.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, 4.0f)));
    }

    @Test
    public void groupByEach() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Function<LongFloatPair, MutableList<Boolean>> function = (LongFloatPair object) -> Lists.mutable.of(PrimitiveTuples.pair(1L, 2.0f).equals(object));
        Multimap<Boolean, LongFloatPair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, 2.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, 3.0f)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, 4.0f)));
    }

    @Test
    public void zip() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f);
        RichIterable<Pair<LongFloatPair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, 2.0f), 1), Tuples.pair(PrimitiveTuples.pair(2L, 3.0f), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, 3.0f), 1), Tuples.pair(PrimitiveTuples.pair(1L, 2.0f), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f);
        RichIterable<Pair<LongFloatPair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, 2.0f), 0), Tuples.pair(PrimitiveTuples.pair(2L, 3.0f), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, 3.0f), 0), Tuples.pair(PrimitiveTuples.pair(1L, 2.0f), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1L, 2.0f)), FastList.newListWith(PrimitiveTuples.pair(2L, 3.0f)), FastList.newListWith(PrimitiveTuples.pair(3L, 4.0f))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
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
        RichIterable<LongFloatPair> notEmpty = this.newWith(1L, 2.0f);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, LongFloatPair> sumAggregator = (AtomicInteger aggregate, LongFloatPair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<LongFloatPair> collection = this.newWith(1L, 2.0f, 2L, 3.0f, 3L, 4.0f);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4.0").intValue());
        Assert.assertEquals(2, aggregation.get("2:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1:2.0").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, LongFloatPair, Integer> sumAggregator = (Integer aggregate, LongFloatPair value) -> (int) (aggregate + value.getOne());
        RichIterable<LongFloatPair> collection = this.newWith(1L, 1.0f, 1L, 2.0f, 2L, 3.0f);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3.0").intValue());
        Assert.assertEquals(1, aggregation.get("1:2.0").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractLongFloatMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractLongFloatMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractLongFloatMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractLongFloatMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractLongFloatMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractLongFloatMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractLongFloatMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractLongFloatMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractLongFloatMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractLongFloatMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractLongFloatMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractLongFloatMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractLongFloatMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractLongFloatMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractLongFloatMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractLongFloatMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractLongFloatMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractLongFloatMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractLongFloatMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractLongFloatMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractLongFloatMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractLongFloatMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractLongFloatMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractLongFloatMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractLongFloatMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractLongFloatMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongFloatMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongFloatMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractLongFloatMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractLongFloatMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractLongFloatMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractLongFloatMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractLongFloatMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractLongFloatMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractLongFloatMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractLongFloatMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractLongFloatMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractLongFloatMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractLongFloatMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractLongFloatMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractLongFloatMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractLongFloatMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractLongFloatMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractLongFloatMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractLongFloatMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractLongFloatMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractLongFloatMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractLongFloatMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractLongFloatMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractLongFloatMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractLongFloatMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractLongFloatMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractLongFloatMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongFloatMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongFloatMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractLongFloatMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractLongFloatMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractLongFloatMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractLongFloatMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractLongFloatMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractLongFloatMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractLongFloatMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractLongFloatMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractLongFloatMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractLongFloatMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractLongFloatMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractLongFloatMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractLongFloatMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractLongFloatMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractLongFloatMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractLongFloatMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractLongFloatMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractLongFloatMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractLongFloatMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractLongFloatMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractLongFloatMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractLongFloatMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractLongFloatMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractLongFloatMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractLongFloatMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractLongFloatMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractLongFloatMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractLongFloatMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractLongFloatMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractLongFloatMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractLongFloatMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractLongFloatMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractLongFloatMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractLongFloatMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractLongFloatMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractLongFloatMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractLongFloatMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractLongFloatMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractLongFloatMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractLongFloatMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractLongFloatMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractLongFloatMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractLongFloatMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractLongFloatMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractLongFloatMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
