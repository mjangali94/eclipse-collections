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
import org.eclipse.collections.api.bag.sorted.MutableSortedBag;
import org.eclipse.collections.api.bimap.MutableBiMap;
import org.eclipse.collections.api.block.function.Function;
import org.eclipse.collections.api.block.function.Function0;
import org.eclipse.collections.api.block.function.Function2;
import org.eclipse.collections.api.block.procedure.Procedure2;
import org.eclipse.collections.api.list.MutableList;
import org.eclipse.collections.api.map.MapIterable;
import org.eclipse.collections.api.map.MutableMap;
import org.eclipse.collections.api.map.primitive.LongObjectMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.LongObjectPair;
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
import org.eclipse.collections.impl.bimap.mutable.HashBiMap;
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
 * Abstract JUnit test for {@link LongObjectMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitiveObjectMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractLongObjectMapKeyValuesViewTestCase {

    public abstract LongObjectMap<Integer> newWithKeysValues(long key1, int value1, long key2, int value2, long key3, int value3);

    public abstract LongObjectMap<Integer> newWithKeysValues(long key1, int value1, long key2, int value2);

    public abstract LongObjectMap<Integer> newWithKeysValues(long key1, int value1);

    public abstract LongObjectMap<Integer> newEmpty();

    public RichIterable<LongObjectPair<Integer>> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<LongObjectPair<Integer>> newWith(long key1, int value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<LongObjectPair<Integer>> newWith(long key1, int value1, long key2, int value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<LongObjectPair<Integer>> newWith(long key1, int value1, long key2, int value2, long key3, int value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(1L, Integer.valueOf(5)))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3))));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(1L, Integer.valueOf(5))));
    }

    @Test
    public void forEach() {
        MutableList<LongObjectPair<Integer>> result = Lists.mutable.of();
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4)));
        MutableList<LongObjectPair<Integer>> result2 = Lists.mutable.of();
        RichIterable<LongObjectPair<Integer>> collection2 = this.newWith(0L, 2, 2L, 3, 3L, 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4)));
    }

    @Test
    public void forEachWith() {
        MutableBag<LongObjectPair<Integer>> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        collection.forEachWith((LongObjectPair<Integer> argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<LongObjectPair<Integer>> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<LongObjectPair<Integer>> collection2 = this.newWith(4L, 2, 2L, 3, 3L, 4);
        collection2.forEachWith((LongObjectPair<Integer> argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(4L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<LongObjectPair<Integer>> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 0L, 3, 3L, 4);
        collection.forEachWithIndex((LongObjectPair<Integer> object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(0L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<LongObjectPair<Integer>> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<LongObjectPair<Integer>> collection2 = this.newWith(2L, 2, 5L, 3, 3L, 4);
        collection2.forEachWithIndex((LongObjectPair<Integer> object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2L, Integer.valueOf(2)), PrimitiveTuples.pair(5L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<LongObjectPair<Integer>> result = this.newWith(1L, 2, 2L, 3, 3L, 4).select(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(3)))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, Integer.valueOf(4)), result);
    }

    @Test
    public void selectWith() {
        MutableList<LongObjectPair<Integer>> result = this.newWith(1L, 2, 2L, 3, 3L, 4).selectWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, Integer.valueOf(4)), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<LongObjectPair<Integer>> result = this.newWith(1L, 2, 2L, 3, 3L, 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, Integer.valueOf(3)), HashBag.<LongObjectPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), result);
    }

    @Test
    public void reject() {
        MutableList<LongObjectPair<Integer>> result = this.newWith(1L, 2, 2L, 3, 3L, 4).reject(Predicates.notEqual(PrimitiveTuples.pair(2L, Integer.valueOf(3)))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, Integer.valueOf(4)), result);
    }

    @Test
    public void rejectWith() {
        MutableList<LongObjectPair<Integer>> result = this.newWith(1L, 2, 2L, 3, 3L, 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2L, Integer.valueOf(3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2L, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1L, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3L, Integer.valueOf(4)), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<LongObjectPair<Integer>> result = this.newWith(1L, 2, 2L, 3, 3L, 4).rejectWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(3)), HashBag.<LongObjectPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(LongObjectPair.class), PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(3L, Integer.valueOf(4)), PrimitiveTuples.pair(2L, Integer.valueOf(3)));
    }

    @Test
    public void collect() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        RichIterable<Integer> result1 = pairs.collect((LongObjectPair<Integer> object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Integer> result2 = pairs.collect(LongObjectPair::getTwo);
        Assert.assertEquals(Bags.immutable.of(2, 3, 4), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectBoolean((LongObjectPair<Integer> each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectByte((LongObjectPair<Integer> anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectChar((LongObjectPair<Integer> anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectDouble((LongObjectPair<Integer> anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectFloat((LongObjectPair<Integer> anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectInt((LongObjectPair<Integer> anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectLong((LongObjectPair<Integer> anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1L, 2, 2L, 3, 3L, 4).collectShort((LongObjectPair<Integer> anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Function<LongObjectPair<Integer>, MutableList<String>> function = (LongObjectPair<Integer> object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2", "2:3", "3:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2", "2:3", "3:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, Integer.valueOf(3)), this.newWith(1L, 2, 2L, 3, 3L, 4).detect(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(3)))));
        Assert.assertNull(this.newWith(1L, 2, 2L, 3, 3L, 4).detect(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(4)))));
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
        Assert.assertEquals(PrimitiveTuples.pair(1L, Integer.valueOf(2)), this.newWith(1L, 2, 2L, 3, 3L, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3L, Integer.valueOf(4)), this.newWith(1L, 2, 2L, 3, 3L, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1L, Integer.valueOf(2)), this.newWith(1L, 2, 2L, 3, 3L, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3L, Integer.valueOf(4)), this.newWith(1L, 2, 2L, 3, 3L, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, Integer.valueOf(3)), this.newWith(1L, 2, 2L, 3, 3L, 4).minBy((LongObjectPair<Integer> object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1L, Integer.valueOf(2)), this.newWith(1L, 2, 2L, 3, 4L, 5).maxBy((LongObjectPair<Integer> object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2L, Integer.valueOf(3)), this.newWith(1L, 2, 2L, 3, 3L, 4).detectWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(3))));
        Assert.assertNull(this.newWith(1L, 2, 2L, 3, 3L, 4).detectWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(4))));
    }

    @Test
    public void detectIfNone() {
        Function0<LongObjectPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(5L, Integer.valueOf(6)));
        Assert.assertEquals(PrimitiveTuples.pair(2L, Integer.valueOf(3)), this.newWith(1L, 2, 2L, 3, 3L, 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(3))), function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, Integer.valueOf(6)), this.newWith(1L, 2, 2L, 3, 3L, 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(4))), function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<LongObjectPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(5L, Integer.valueOf(6)));
        Assert.assertEquals(PrimitiveTuples.pair(2L, Integer.valueOf(3)), this.newWith(1L, 2, 2L, 3, 3L, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(3)), function));
        Assert.assertEquals(PrimitiveTuples.pair(5L, Integer.valueOf(6)), this.newWith(1L, 2, 2L, 3, 3L, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(4)), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).allSatisfy(LongObjectPair.class::isInstance));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).allSatisfy(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(3)))));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).allSatisfyWith(Predicates2.instanceOf(), LongObjectPair.class));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(3))));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).noneSatisfy(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(3)))));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(3))));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(3)))));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(5)))));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1L, 2, 2L, 3, 3L, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(3))));
        Assert.assertFalse(this.newWith(1L, 2, 2L, 3, 3L, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(5))));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1L, 2, 2L, 3, 3L, 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1L, 2, 2L, 3, 3L, 4).count(LongObjectPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1L, 2, 2L, 3, 3L, 4).count(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(3)))));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1L, 2, 2L, 3, 3L, 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1L, 2, 2L, 3, 3L, 4).countWith(Predicates2.instanceOf(), LongObjectPair.class));
        Assert.assertEquals(1, this.newWith(1L, 2, 2L, 3, 3L, 4).countWith(Object::equals, PrimitiveTuples.pair(2L, Integer.valueOf(3))));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1L, 2, 2L, 3, 3L, 4).collectIf(LongObjectPair.class::isInstance, String::valueOf), "1:2", "2:3", "3:4");
        Verify.assertContainsAll(this.newWith(1L, 2, 2L, 3, 3L, 4).collectIf(LongObjectPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1L, 2, 2L, 3, 3L, 4).collectWith((LongObjectPair<Integer> argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1L, 2, 2L, 3, 3L, 4).collectWith((LongObjectPair<Integer> argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        LongObjectPair<Integer> first = this.newWith(1L, 2, 2L, 3, 3L, 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1L, Integer.valueOf(2)).equals(first) || PrimitiveTuples.pair(2L, Integer.valueOf(3)).equals(first) || PrimitiveTuples.pair(3L, Integer.valueOf(4)).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1L, Integer.valueOf(2)), this.newWith(1L, 2).getFirst());
    }

    @Test
    public void getLast() {
        LongObjectPair<Integer> last = this.newWith(1L, 2, 2L, 3, 3L, 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1L, Integer.valueOf(2)).equals(last) || PrimitiveTuples.pair(2L, Integer.valueOf(3)).equals(last) || PrimitiveTuples.pair(3L, Integer.valueOf(4)).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1L, Integer.valueOf(2)), this.newWith(1L, 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1L, 2));
        Assert.assertTrue(this.newWith(1L, 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 0L, 3, 3L, 4);
        MutableBag<LongObjectPair<Integer>> actual = Bags.mutable.of();
        Iterator<LongObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(2L, 2, 4L, 3, 3L, 4);
        MutableBag<LongObjectPair<Integer>> actual = Bags.mutable.of();
        Iterator<LongObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Iterator<LongObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Iterator<LongObjectPair<Integer>> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Long result = objects.injectInto(1L, (Long argument1, LongObjectPair<Integer> argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        int result = objects.injectInto(1, (int intParameter, LongObjectPair<Integer> argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        long result = objects.injectInto(1L, (long parameter, LongObjectPair<Integer> argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        double result = objects.injectInto(1.0, (double parameter, LongObjectPair<Integer> argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        float result = objects.injectInto(1.0f, (float parameter, LongObjectPair<Integer> argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        double actual = objects.sumOfFloat((LongObjectPair<Integer> each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        double actual = objects.sumOfDouble((LongObjectPair<Integer> each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        long actual = objects.sumOfInt((LongObjectPair<Integer> each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        long actual = objects.sumOfLong((LongObjectPair<Integer> each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<LongObjectPair<Integer>> objects = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        LongObjectPair<Integer>[] array2 = objects.toArray(new LongObjectPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<LongObjectPair<Integer>> result = this.newWith(1L, 2, 2L, 3, 3L, 4).partition(Predicates.equal(PrimitiveTuples.pair(2L, Integer.valueOf(3))));
        Verify.assertContains(PrimitiveTuples.pair(2L, Integer.valueOf(3)), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1L, Integer.valueOf(2)), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3L, Integer.valueOf(4)), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<LongObjectPair<Integer>> list = this.newWith(1L, 2, 2L, 3, 3L, 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4)));
    }

    @Test
    public void toBag() {
        MutableBag<LongObjectPair<Integer>> bag = this.newWith(1L, 2, 2L, 3, 3L, 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4)));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableList<LongObjectPair<Integer>> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableList<LongObjectPair<Integer>> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3L, Integer.valueOf(4)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(1L, Integer.valueOf(2))), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableList<LongObjectPair<Integer>> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedBag<LongObjectPair<Integer>> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedBag<LongObjectPair<Integer>> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, Integer.valueOf(4)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(1L, Integer.valueOf(2))), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedBag<LongObjectPair<Integer>> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedSet<LongObjectPair<Integer>> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedSet<LongObjectPair<Integer>> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3L, Integer.valueOf(4)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(1L, Integer.valueOf(2))), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(2L, 3, 1L, 2, 3L, 4);
        MutableSortedSet<LongObjectPair<Integer>> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4))), set);
    }

    @Test
    public void toSet() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableSet<LongObjectPair<Integer>> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1L, Integer.valueOf(2)), PrimitiveTuples.pair(2L, Integer.valueOf(3)), PrimitiveTuples.pair(3L, Integer.valueOf(4)));
    }

    @Test
    public void toMap() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toBiMap() {
        RichIterable<LongObjectPair<Integer>> pairs = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MutableBiMap<String, String> biMap = pairs.toBiMap(String::valueOf, String::valueOf);
        Assert.assertEquals(HashBiMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), biMap);
    }

    @Test
    public void testToString() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString()) || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Function<LongObjectPair<Integer>, Boolean> function = (LongObjectPair<Integer> object) -> PrimitiveTuples.pair(1L, Integer.valueOf(2)).equals(object);
        Multimap<Boolean, LongObjectPair<Integer>> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, Integer.valueOf(2))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, Integer.valueOf(3))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, Integer.valueOf(4))));
    }

    @Test
    public void groupByEach() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Function<LongObjectPair<Integer>, MutableList<Boolean>> function = (LongObjectPair<Integer> object) -> Lists.mutable.of(PrimitiveTuples.pair(1L, Integer.valueOf(2)).equals(object));
        Multimap<Boolean, LongObjectPair<Integer>> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1L, Integer.valueOf(2))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2L, Integer.valueOf(3))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3L, Integer.valueOf(4))));
    }

    @Test
    public void zip() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3);
        RichIterable<Pair<LongObjectPair<Integer>, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, Integer.valueOf(2)), 1), Tuples.pair(PrimitiveTuples.pair(2L, Integer.valueOf(3)), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, Integer.valueOf(3)), 1), Tuples.pair(PrimitiveTuples.pair(1L, Integer.valueOf(2)), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3);
        RichIterable<Pair<LongObjectPair<Integer>, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1L, Integer.valueOf(2)), 0), Tuples.pair(PrimitiveTuples.pair(2L, Integer.valueOf(3)), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2L, Integer.valueOf(3)), 0), Tuples.pair(PrimitiveTuples.pair(1L, Integer.valueOf(2)), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1L, Integer.valueOf(2))), FastList.newListWith(PrimitiveTuples.pair(2L, Integer.valueOf(3))), FastList.newListWith(PrimitiveTuples.pair(3L, Integer.valueOf(4)))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
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
        RichIterable<LongObjectPair<Integer>> notEmpty = this.newWith(1L, 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, LongObjectPair<Integer>> sumAggregator = (AtomicInteger aggregate, LongObjectPair<Integer> value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 2, 2L, 3, 3L, 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, LongObjectPair<Integer>, Integer> sumAggregator = (Integer aggregate, LongObjectPair<Integer> value) -> (int) (aggregate + value.getOne());
        RichIterable<LongObjectPair<Integer>> collection = this.newWith(1L, 1, 1L, 2, 2L, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static abstract class _Benchmark extends se.chalmers.ju2jmh.api.JU2JmhBenchmark {

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllIterable() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllIterable, this.description("containsAllIterable"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_containsAllArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::containsAllArray, this.description("containsAllArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEach, this.description("forEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWith, this.description("forEachWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_forEachWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::forEachWithIndex, this.description("forEachWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_select() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::select, this.description("select"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith, this.description("selectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectWith_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectWith_target, this.description("selectWith_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_reject() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::reject, this.description("reject"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith, this.description("rejectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_rejectWith_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::rejectWith_target, this.description("rejectWith_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_selectInstancesOf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::selectInstancesOf, this.description("selectInstancesOf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collect, this.description("collect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectBoolean() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectBoolean, this.description("collectBoolean"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectByte() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectByte, this.description("collectByte"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectChar() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectChar, this.description("collectChar"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectDouble, this.description("collectDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectFloat, this.description("collectFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectInt, this.description("collectInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectLong, this.description("collectLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectShort() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectShort, this.description("collectShort"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_flatCollect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::flatCollect, this.description("flatCollect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detect() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detect, this.description("detect"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_empty_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::min_empty_throws, this.description("min_empty_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_empty_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::max_empty_throws, this.description("max_empty_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min, this.description("min"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max, this.description("max"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_min_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::min_without_comparator, this.description("min_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_max_without_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::max_without_comparator, this.description("max_without_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_minBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::minBy, this.description("minBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_maxBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::maxBy, this.description("maxBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWith, this.description("detectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectIfNone() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectIfNone, this.description("detectIfNone"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_detectWithIfNoneBlock() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::detectWithIfNoneBlock, this.description("detectWithIfNoneBlock"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfy, this.description("allSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_allSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::allSatisfyWith, this.description("allSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfy, this.description("noneSatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_noneSatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::noneSatisfyWith, this.description("noneSatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfy, this.description("anySatisfy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_anySatisfyWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::anySatisfyWith, this.description("anySatisfyWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_count() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::count, this.description("count"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_countWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::countWith, this.description("countWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectIf() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectIf, this.description("collectIf"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith, this.description("collectWith"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_collectWith_target() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::collectWith_target, this.description("collectWith_target"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getFirst() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getFirst, this.description("getFirst"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_getLast() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::getLast, this.description("getLast"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_isEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::isEmpty, this.description("isEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator, this.description("iterator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_no_sentinels() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::iterator_no_sentinels, this.description("iterator_no_sentinels"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_next_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::iterator_next_throws, this.description("iterator_next_throws"), java.util.NoSuchElementException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_iterator_remove_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::iterator_remove_throws, this.description("iterator_remove_throws"), java.lang.UnsupportedOperationException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectInto() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectInto, this.description("injectInto"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoInt() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoInt, this.description("injectIntoInt"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoLong, this.description("injectIntoLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoDouble, this.description("injectIntoDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_injectIntoFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::injectIntoFloat, this.description("injectIntoFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumFloat() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumFloat, this.description("sumFloat"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumDouble() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumDouble, this.description("sumDouble"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumInteger() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumInteger, this.description("sumInteger"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_sumLong() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::sumLong, this.description("sumLong"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toArray() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toArray, this.description("toArray"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_partition() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::partition, this.description("partition"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toList() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toList, this.description("toList"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBag() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBag, this.description("toBag"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_natural_ordering() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList_natural_ordering, this.description("toSortedList_natural_ordering"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedList_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedList_with_comparator, this.description("toSortedList_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedListBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedListBy, this.description("toSortedListBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_natural_ordering() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_natural_ordering, this.description("toSortedBag_natural_ordering"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBag_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBag_with_comparator, this.description("toSortedBag_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedBagBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedBagBy, this.description("toSortedBagBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_natural_ordering() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSet_natural_ordering, this.description("toSortedSet_natural_ordering"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSet_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSet_with_comparator, this.description("toSortedSet_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedSetBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedSetBy, this.description("toSortedSetBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSet() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSet, this.description("toSet"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toMap, this.description("toMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMap, this.description("toSortedMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMap_with_comparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMap_with_comparator, this.description("toSortedMap_with_comparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toSortedMapBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toSortedMapBy, this.description("toSortedMapBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::toBiMap, this.description("toBiMap"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_testToString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::testToString, this.description("testToString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeString, this.description("makeString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeStringWithSeparator, this.description("makeStringWithSeparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_makeStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::makeStringWithSeparatorAndStartAndEnd, this.description("makeStringWithSeparatorAndStartAndEnd"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendString() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendString, this.description("appendString"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparator() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendStringWithSeparator, this.description("appendStringWithSeparator"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_appendStringWithSeparatorAndStartAndEnd() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::appendStringWithSeparatorAndStartAndEnd, this.description("appendStringWithSeparatorAndStartAndEnd"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupBy() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupBy, this.description("groupBy"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_groupByEach() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::groupByEach, this.description("groupByEach"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zip() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zip, this.description("zip"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_zipWithIndex() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::zipWithIndex, this.description("zipWithIndex"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk, this.description("chunk"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_zero_throws() throws java.lang.Throwable {
            this.createImplementation();
            this.runExceptionBenchmark(this.implementation()::chunk_zero_throws, this.description("chunk_zero_throws"), java.lang.IllegalArgumentException.class);
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_chunk_large_size() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::chunk_large_size, this.description("chunk_large_size"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_empty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::empty, this.description("empty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_notEmpty() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::notEmpty, this.description("notEmpty"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByMutating() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateByMutating, this.description("aggregateByMutating"));
        }

        @org.openjdk.jmh.annotations.Benchmark
        public void benchmark_aggregateByNonMutating() throws java.lang.Throwable {
            this.createImplementation();
            this.runBenchmark(this.implementation()::aggregateByNonMutating, this.description("aggregateByNonMutating"));
        }

        @java.lang.Override
        public abstract void createImplementation() throws java.lang.Throwable;

        @java.lang.Override
        public abstract AbstractLongObjectMapKeyValuesViewTestCase implementation();
    }
}
