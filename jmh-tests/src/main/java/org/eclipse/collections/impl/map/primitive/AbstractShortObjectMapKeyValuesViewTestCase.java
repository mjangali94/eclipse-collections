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
import org.eclipse.collections.api.map.primitive.ShortObjectMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.ShortObjectPair;
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
 * Abstract JUnit test for {@link ShortObjectMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitiveObjectMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractShortObjectMapKeyValuesViewTestCase {

    public abstract ShortObjectMap<Integer> newWithKeysValues(short key1, int value1, short key2, int value2, short key3, int value3);

    public abstract ShortObjectMap<Integer> newWithKeysValues(short key1, int value1, short key2, int value2);

    public abstract ShortObjectMap<Integer> newWithKeysValues(short key1, int value1);

    public abstract ShortObjectMap<Integer> newEmpty();

    public RichIterable<ShortObjectPair<Integer>> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<ShortObjectPair<Integer>> newWith(short key1, int value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<ShortObjectPair<Integer>> newWith(short key1, int value1, short key2, int value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<ShortObjectPair<Integer>> newWith(short key1, int value1, short key2, int value2, short key3, int value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 1, Integer.valueOf(5)))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 1, Integer.valueOf(5))));
    }

    @Test
    public void forEach() {
        MutableList<ShortObjectPair<Integer>> result = Lists.mutable.of();
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4)));
        MutableList<ShortObjectPair<Integer>> result2 = Lists.mutable.of();
        RichIterable<ShortObjectPair<Integer>> collection2 = this.newWith((short) 0, 2, (short) 2, 3, (short) 3, 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair((short) 0, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4)));
    }

    @Test
    public void forEachWith() {
        MutableBag<ShortObjectPair<Integer>> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        collection.forEachWith((ShortObjectPair<Integer> argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<ShortObjectPair<Integer>> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<ShortObjectPair<Integer>> collection2 = this.newWith((short) 4, 2, (short) 2, 3, (short) 3, 4);
        collection2.forEachWith((ShortObjectPair<Integer> argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 4, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<ShortObjectPair<Integer>> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 0, 3, (short) 3, 4);
        collection.forEachWithIndex((ShortObjectPair<Integer> object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 0, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<ShortObjectPair<Integer>> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<ShortObjectPair<Integer>> collection2 = this.newWith((short) 2, 2, (short) 5, 3, (short) 3, 4);
        collection2.forEachWithIndex((ShortObjectPair<Integer> object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair((short) 2, Integer.valueOf(2)), PrimitiveTuples.pair((short) 5, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<ShortObjectPair<Integer>> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).select(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)))).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), result);
    }

    @Test
    public void selectWith() {
        MutableList<ShortObjectPair<Integer>> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).selectWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(3))).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<ShortObjectPair<Integer>> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), HashBag.<ShortObjectPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), result);
    }

    @Test
    public void reject() {
        MutableList<ShortObjectPair<Integer>> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).reject(Predicates.notEqual(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)))).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), result);
    }

    @Test
    public void rejectWith() {
        MutableList<ShortObjectPair<Integer>> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair((short) 2, Integer.valueOf(3))).toList();
        Verify.assertContains(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<ShortObjectPair<Integer>> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).rejectWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), HashBag.<ShortObjectPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(ShortObjectPair.class), PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)));
    }

    @Test
    public void collect() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        RichIterable<Integer> result1 = pairs.collect((ShortObjectPair<Integer> object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Integer> result2 = pairs.collect(ShortObjectPair::getTwo);
        Assert.assertEquals(Bags.immutable.of(2, 3, 4), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectBoolean((ShortObjectPair<Integer> each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectByte((ShortObjectPair<Integer> anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectChar((ShortObjectPair<Integer> anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectDouble((ShortObjectPair<Integer> anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectFloat((ShortObjectPair<Integer> anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectInt((ShortObjectPair<Integer> anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectLong((ShortObjectPair<Integer> anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectShort((ShortObjectPair<Integer> anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Function<ShortObjectPair<Integer>, MutableList<String>> function = (ShortObjectPair<Integer> object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2", "2:3", "3:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2", "2:3", "3:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detect(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)))));
        Assert.assertNull(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detect(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(4)))));
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
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).minBy((ShortObjectPair<Integer> object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), this.newWith((short) 1, 2, (short) 2, 3, (short) 4, 5).maxBy((ShortObjectPair<Integer> object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
        Assert.assertNull(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(4))));
    }

    @Test
    public void detectIfNone() {
        Function0<ShortObjectPair<Integer>> function = Functions0.value(PrimitiveTuples.pair((short) 5, Integer.valueOf(6)));
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(3))), function));
        Assert.assertEquals(PrimitiveTuples.pair((short) 5, Integer.valueOf(6)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(4))), function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<ShortObjectPair<Integer>> function = Functions0.value(PrimitiveTuples.pair((short) 5, Integer.valueOf(6)));
        Assert.assertEquals(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), function));
        Assert.assertEquals(PrimitiveTuples.pair((short) 5, Integer.valueOf(6)), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(4)), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).allSatisfy(ShortObjectPair.class::isInstance));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).allSatisfy(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)))));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).allSatisfyWith(Predicates2.instanceOf(), ShortObjectPair.class));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).noneSatisfy(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)))));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)))));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(5)))));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
        Assert.assertFalse(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(5))));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).count(ShortObjectPair.class::isInstance));
        Assert.assertEquals(1, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).count(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)))));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).countWith(Predicates2.instanceOf(), ShortObjectPair.class));
        Assert.assertEquals(1, this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).countWith(Object::equals, PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectIf(ShortObjectPair.class::isInstance, String::valueOf), "1:2", "2:3", "3:4");
        Verify.assertContainsAll(this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectIf(ShortObjectPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectWith((ShortObjectPair<Integer> argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).collectWith((ShortObjectPair<Integer> argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        ShortObjectPair<Integer> first = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)).equals(first) || PrimitiveTuples.pair((short) 2, Integer.valueOf(3)).equals(first) || PrimitiveTuples.pair((short) 3, Integer.valueOf(4)).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), this.newWith((short) 1, 2).getFirst());
    }

    @Test
    public void getLast() {
        ShortObjectPair<Integer> last = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)).equals(last) || PrimitiveTuples.pair((short) 2, Integer.valueOf(3)).equals(last) || PrimitiveTuples.pair((short) 3, Integer.valueOf(4)).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), this.newWith((short) 1, 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith((short) 1, 2));
        Assert.assertTrue(this.newWith((short) 1, 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 0, 3, (short) 3, 4);
        MutableBag<ShortObjectPair<Integer>> actual = Bags.mutable.of();
        Iterator<ShortObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 2, 2, (short) 4, 3, (short) 3, 4);
        MutableBag<ShortObjectPair<Integer>> actual = Bags.mutable.of();
        Iterator<ShortObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Iterator<ShortObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Iterator<ShortObjectPair<Integer>> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Long result = objects.injectInto(1L, (Long argument1, ShortObjectPair<Integer> argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        int result = objects.injectInto(1, (int intParameter, ShortObjectPair<Integer> argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        long result = objects.injectInto(1L, (long parameter, ShortObjectPair<Integer> argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        double result = objects.injectInto(1.0, (double parameter, ShortObjectPair<Integer> argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        float result = objects.injectInto(1.0f, (float parameter, ShortObjectPair<Integer> argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        double actual = objects.sumOfFloat((ShortObjectPair<Integer> each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        double actual = objects.sumOfDouble((ShortObjectPair<Integer> each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        long actual = objects.sumOfInt((ShortObjectPair<Integer> each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        long actual = objects.sumOfLong((ShortObjectPair<Integer> each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<ShortObjectPair<Integer>> objects = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        ShortObjectPair<Integer>[] array2 = objects.toArray(new ShortObjectPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<ShortObjectPair<Integer>> result = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).partition(Predicates.equal(PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
        Verify.assertContains(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<ShortObjectPair<Integer>> list = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4)));
    }

    @Test
    public void toBag() {
        MutableBag<ShortObjectPair<Integer>> bag = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4)));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableList<ShortObjectPair<Integer>> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableList<ShortObjectPair<Integer>> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 1, Integer.valueOf(2))), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableList<ShortObjectPair<Integer>> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedBag<ShortObjectPair<Integer>> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedBag<ShortObjectPair<Integer>> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 1, Integer.valueOf(2))), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedBag<ShortObjectPair<Integer>> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedSet<ShortObjectPair<Integer>> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedSet<ShortObjectPair<Integer>> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair((short) 3, Integer.valueOf(4)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 1, Integer.valueOf(2))), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 2, 3, (short) 1, 2, (short) 3, 4);
        MutableSortedSet<ShortObjectPair<Integer>> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4))), set);
    }

    @Test
    public void toSet() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableSet<ShortObjectPair<Integer>> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), PrimitiveTuples.pair((short) 3, Integer.valueOf(4)));
    }

    @Test
    public void toMap() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toBiMap() {
        RichIterable<ShortObjectPair<Integer>> pairs = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MutableBiMap<String, String> biMap = pairs.toBiMap(String::valueOf, String::valueOf);
        Assert.assertEquals(HashBiMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), biMap);
    }

    @Test
    public void testToString() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString()) || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Function<ShortObjectPair<Integer>, Boolean> function = (ShortObjectPair<Integer> object) -> PrimitiveTuples.pair((short) 1, Integer.valueOf(2)).equals(object);
        Multimap<Boolean, ShortObjectPair<Integer>> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((short) 1, Integer.valueOf(2))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 3, Integer.valueOf(4))));
    }

    @Test
    public void groupByEach() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Function<ShortObjectPair<Integer>, MutableList<Boolean>> function = (ShortObjectPair<Integer> object) -> Lists.mutable.of(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)).equals(object));
        Multimap<Boolean, ShortObjectPair<Integer>> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair((short) 1, Integer.valueOf(2))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 2, Integer.valueOf(3))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair((short) 3, Integer.valueOf(4))));
    }

    @Test
    public void zip() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3);
        RichIterable<Pair<ShortObjectPair<Integer>, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), 1), Tuples.pair(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), 1), Tuples.pair(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3);
        RichIterable<Pair<ShortObjectPair<Integer>, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), 0), Tuples.pair(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair((short) 2, Integer.valueOf(3)), 0), Tuples.pair(PrimitiveTuples.pair((short) 1, Integer.valueOf(2)), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair((short) 1, Integer.valueOf(2))), FastList.newListWith(PrimitiveTuples.pair((short) 2, Integer.valueOf(3))), FastList.newListWith(PrimitiveTuples.pair((short) 3, Integer.valueOf(4)))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
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
        RichIterable<ShortObjectPair<Integer>> notEmpty = this.newWith((short) 1, 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, ShortObjectPair<Integer>> sumAggregator = (AtomicInteger aggregate, ShortObjectPair<Integer> value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 2, (short) 2, 3, (short) 3, 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, ShortObjectPair<Integer>, Integer> sumAggregator = (Integer aggregate, ShortObjectPair<Integer> value) -> (int) (aggregate + value.getOne());
        RichIterable<ShortObjectPair<Integer>> collection = this.newWith((short) 1, 1, (short) 1, 2, (short) 2, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

/*
    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractShortObjectMapKeyValuesViewTestCase instance;

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
        public void benchmark_toBiMap() throws java.lang.Throwable {
            this.runBenchmark(this.payloads.toBiMap);
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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractShortObjectMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractShortObjectMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractShortObjectMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractShortObjectMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractShortObjectMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractShortObjectMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractShortObjectMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractShortObjectMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractShortObjectMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractShortObjectMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractShortObjectMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractShortObjectMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractShortObjectMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractShortObjectMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractShortObjectMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractShortObjectMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractShortObjectMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractShortObjectMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractShortObjectMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractShortObjectMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractShortObjectMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractShortObjectMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractShortObjectMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractShortObjectMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractShortObjectMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortObjectMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortObjectMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractShortObjectMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractShortObjectMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractShortObjectMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractShortObjectMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractShortObjectMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractShortObjectMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractShortObjectMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractShortObjectMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractShortObjectMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractShortObjectMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractShortObjectMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractShortObjectMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractShortObjectMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractShortObjectMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractShortObjectMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractShortObjectMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractShortObjectMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractShortObjectMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractShortObjectMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractShortObjectMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractShortObjectMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractShortObjectMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractShortObjectMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractShortObjectMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractShortObjectMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortObjectMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortObjectMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractShortObjectMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractShortObjectMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractShortObjectMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractShortObjectMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractShortObjectMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractShortObjectMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractShortObjectMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractShortObjectMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractShortObjectMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractShortObjectMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractShortObjectMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractShortObjectMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractShortObjectMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractShortObjectMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractShortObjectMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractShortObjectMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractShortObjectMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractShortObjectMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractShortObjectMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractShortObjectMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractShortObjectMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractShortObjectMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractShortObjectMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractShortObjectMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractShortObjectMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractShortObjectMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractShortObjectMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractShortObjectMapKeyValuesViewTestCase::toBiMap;
            this.payloads.testToString = AbstractShortObjectMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractShortObjectMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractShortObjectMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractShortObjectMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractShortObjectMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractShortObjectMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractShortObjectMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractShortObjectMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractShortObjectMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractShortObjectMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractShortObjectMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractShortObjectMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractShortObjectMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractShortObjectMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractShortObjectMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractShortObjectMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractShortObjectMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractShortObjectMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
*/
}
