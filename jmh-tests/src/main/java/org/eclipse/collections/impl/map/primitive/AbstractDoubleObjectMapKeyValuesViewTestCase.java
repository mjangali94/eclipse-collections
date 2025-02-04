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
import org.eclipse.collections.api.map.primitive.DoubleObjectMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.DoubleObjectPair;
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
 * Abstract JUnit test for {@link DoubleObjectMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitiveObjectMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractDoubleObjectMapKeyValuesViewTestCase {

    public abstract DoubleObjectMap<Integer> newWithKeysValues(double key1, int value1, double key2, int value2, double key3, int value3);

    public abstract DoubleObjectMap<Integer> newWithKeysValues(double key1, int value1, double key2, int value2);

    public abstract DoubleObjectMap<Integer> newWithKeysValues(double key1, int value1);

    public abstract DoubleObjectMap<Integer> newEmpty();

    public RichIterable<DoubleObjectPair<Integer>> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<DoubleObjectPair<Integer>> newWith(double key1, int value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<DoubleObjectPair<Integer>> newWith(double key1, int value1, double key2, int value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<DoubleObjectPair<Integer>> newWith(double key1, int value1, double key2, int value2, double key3, int value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(1.0, Integer.valueOf(5)))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(1.0, Integer.valueOf(5))));
    }

    @Test
    public void forEach() {
        MutableList<DoubleObjectPair<Integer>> result = Lists.mutable.of();
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4)));
        MutableList<DoubleObjectPair<Integer>> result2 = Lists.mutable.of();
        RichIterable<DoubleObjectPair<Integer>> collection2 = this.newWith(0.0, 2, 2.0, 3, 3.0, 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4)));
    }

    @Test
    public void forEachWith() {
        MutableBag<DoubleObjectPair<Integer>> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        collection.forEachWith((DoubleObjectPair<Integer> argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<DoubleObjectPair<Integer>> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<DoubleObjectPair<Integer>> collection2 = this.newWith(4.0, 2, 2.0, 3, 3.0, 4);
        collection2.forEachWith((DoubleObjectPair<Integer> argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(4.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<DoubleObjectPair<Integer>> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 0.0, 3, 3.0, 4);
        collection.forEachWithIndex((DoubleObjectPair<Integer> object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(0.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<DoubleObjectPair<Integer>> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<DoubleObjectPair<Integer>> collection2 = this.newWith(2.0, 2, 5.0, 3, 3.0, 4);
        collection2.forEachWithIndex((DoubleObjectPair<Integer> object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2.0, Integer.valueOf(2)), PrimitiveTuples.pair(5.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<DoubleObjectPair<Integer>> result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).select(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(3)))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, Integer.valueOf(4)), result);
    }

    @Test
    public void selectWith() {
        MutableList<DoubleObjectPair<Integer>> result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).selectWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, Integer.valueOf(4)), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<DoubleObjectPair<Integer>> result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), HashBag.<DoubleObjectPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), result);
    }

    @Test
    public void reject() {
        MutableList<DoubleObjectPair<Integer>> result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).reject(Predicates.notEqual(PrimitiveTuples.pair(2.0, Integer.valueOf(3)))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, Integer.valueOf(4)), result);
    }

    @Test
    public void rejectWith() {
        MutableList<DoubleObjectPair<Integer>> result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2.0, Integer.valueOf(3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3.0, Integer.valueOf(4)), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<DoubleObjectPair<Integer>> result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).rejectWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(3)), HashBag.<DoubleObjectPair<Integer>>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(DoubleObjectPair.class), PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(3.0, Integer.valueOf(4)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)));
    }

    @Test
    public void collect() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        RichIterable<Integer> result1 = pairs.collect((DoubleObjectPair<Integer> object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Integer> result2 = pairs.collect(DoubleObjectPair::getTwo);
        Assert.assertEquals(Bags.immutable.of(2, 3, 4), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectBoolean((DoubleObjectPair<Integer> each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectByte((DoubleObjectPair<Integer> anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectChar((DoubleObjectPair<Integer> anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectDouble((DoubleObjectPair<Integer> anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectFloat((DoubleObjectPair<Integer> anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectInt((DoubleObjectPair<Integer> anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectLong((DoubleObjectPair<Integer> anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectShort((DoubleObjectPair<Integer> anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Function<DoubleObjectPair<Integer>, MutableList<String>> function = (DoubleObjectPair<Integer> object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1.0:2", "2.0:3", "3.0:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1.0:2", "2.0:3", "3.0:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).detect(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(3)))));
        Assert.assertNull(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).detect(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(4)))));
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
        Assert.assertEquals(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0, Integer.valueOf(4)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3.0, Integer.valueOf(4)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).minBy((DoubleObjectPair<Integer> object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), this.newWith(1.0, 2, 2.0, 3, 4.0, 5).maxBy((DoubleObjectPair<Integer> object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).detectWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
        Assert.assertNull(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).detectWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(4))));
    }

    @Test
    public void detectIfNone() {
        Function0<DoubleObjectPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(5.0, Integer.valueOf(6)));
        Assert.assertEquals(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(3))), function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0, Integer.valueOf(6)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).detectIfNone(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(4))), function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<DoubleObjectPair<Integer>> function = Functions0.value(PrimitiveTuples.pair(5.0, Integer.valueOf(6)));
        Assert.assertEquals(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(3)), function));
        Assert.assertEquals(PrimitiveTuples.pair(5.0, Integer.valueOf(6)), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(4)), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).allSatisfy(DoubleObjectPair.class::isInstance));
        Assert.assertFalse(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).allSatisfy(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(3)))));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).allSatisfyWith(Predicates2.instanceOf(), DoubleObjectPair.class));
        Assert.assertFalse(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).noneSatisfy(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(3)))));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(3)))));
        Assert.assertFalse(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).anySatisfy(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(5)))));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
        Assert.assertFalse(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(5))));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1.0, 2, 2.0, 3, 3.0, 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1.0, 2, 2.0, 3, 3.0, 4).count(DoubleObjectPair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1.0, 2, 2.0, 3, 3.0, 4).count(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(3)))));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1.0, 2, 2.0, 3, 3.0, 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1.0, 2, 2.0, 3, 3.0, 4).countWith(Predicates2.instanceOf(), DoubleObjectPair.class));
        Assert.assertEquals(1, this.newWith(1.0, 2, 2.0, 3, 3.0, 4).countWith(Object::equals, PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectIf(DoubleObjectPair.class::isInstance, String::valueOf), "1.0:2", "2.0:3", "3.0:4");
        Verify.assertContainsAll(this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectIf(DoubleObjectPair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1.0:2", "2.0:3", "3.0:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectWith((DoubleObjectPair<Integer> argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1.0, 2, 2.0, 3, 3.0, 4).collectWith((DoubleObjectPair<Integer> argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        DoubleObjectPair<Integer> first = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1.0, Integer.valueOf(2)).equals(first) || PrimitiveTuples.pair(2.0, Integer.valueOf(3)).equals(first) || PrimitiveTuples.pair(3.0, Integer.valueOf(4)).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), this.newWith(1.0, 2).getFirst());
    }

    @Test
    public void getLast() {
        DoubleObjectPair<Integer> last = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1.0, Integer.valueOf(2)).equals(last) || PrimitiveTuples.pair(2.0, Integer.valueOf(3)).equals(last) || PrimitiveTuples.pair(3.0, Integer.valueOf(4)).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), this.newWith(1.0, 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1.0, 2));
        Assert.assertTrue(this.newWith(1.0, 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 0.0, 3, 3.0, 4);
        MutableBag<DoubleObjectPair<Integer>> actual = Bags.mutable.of();
        Iterator<DoubleObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(2.0, 2, 4.0, 3, 3.0, 4);
        MutableBag<DoubleObjectPair<Integer>> actual = Bags.mutable.of();
        Iterator<DoubleObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Iterator<DoubleObjectPair<Integer>> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Iterator<DoubleObjectPair<Integer>> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Long result = objects.injectInto(1L, (Long argument1, DoubleObjectPair<Integer> argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        int result = objects.injectInto(1, (int intParameter, DoubleObjectPair<Integer> argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        long result = objects.injectInto(1L, (long parameter, DoubleObjectPair<Integer> argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        double result = objects.injectInto(1.0, (double parameter, DoubleObjectPair<Integer> argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        float result = objects.injectInto(1.0f, (float parameter, DoubleObjectPair<Integer> argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        double actual = objects.sumOfFloat((DoubleObjectPair<Integer> each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        double actual = objects.sumOfDouble((DoubleObjectPair<Integer> each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        long actual = objects.sumOfInt((DoubleObjectPair<Integer> each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        long actual = objects.sumOfLong((DoubleObjectPair<Integer> each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<DoubleObjectPair<Integer>> objects = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        DoubleObjectPair<Integer>[] array2 = objects.toArray(new DoubleObjectPair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<DoubleObjectPair<Integer>> result = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).partition(Predicates.equal(PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
        Verify.assertContains(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3.0, Integer.valueOf(4)), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<DoubleObjectPair<Integer>> list = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4)));
    }

    @Test
    public void toBag() {
        MutableBag<DoubleObjectPair<Integer>> bag = this.newWith(1.0, 2, 2.0, 3, 3.0, 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4)));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableList<DoubleObjectPair<Integer>> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableList<DoubleObjectPair<Integer>> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3.0, Integer.valueOf(4)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(1.0, Integer.valueOf(2))), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableList<DoubleObjectPair<Integer>> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableSortedBag<DoubleObjectPair<Integer>> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableSortedBag<DoubleObjectPair<Integer>> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0, Integer.valueOf(4)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(1.0, Integer.valueOf(2))), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableSortedBag<DoubleObjectPair<Integer>> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableSortedSet<DoubleObjectPair<Integer>> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableSortedSet<DoubleObjectPair<Integer>> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3.0, Integer.valueOf(4)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(1.0, Integer.valueOf(2))), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(2.0, 3, 1.0, 2, 3.0, 4);
        MutableSortedSet<DoubleObjectPair<Integer>> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4))), set);
    }

    @Test
    public void toSet() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        MutableSet<DoubleObjectPair<Integer>> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1.0, Integer.valueOf(2)), PrimitiveTuples.pair(2.0, Integer.valueOf(3)), PrimitiveTuples.pair(3.0, Integer.valueOf(4)));
    }

    @Test
    public void toMap() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), map);
    }

    @Test
    public void toBiMap() {
        RichIterable<DoubleObjectPair<Integer>> pairs = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        MutableBiMap<String, String> biMap = pairs.toBiMap(String::valueOf, String::valueOf);
        Assert.assertEquals(HashBiMap.newWithKeysValues("1.0:2", "1.0:2", "2.0:3", "2.0:3", "3.0:4", "3.0:4"), biMap);
    }

    @Test
    public void testToString() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3);
        Assert.assertTrue("[1.0:2, 2.0:3]".equals(collection.toString()) || "[2.0:3, 1.0:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Function<DoubleObjectPair<Integer>, Boolean> function = (DoubleObjectPair<Integer> object) -> PrimitiveTuples.pair(1.0, Integer.valueOf(2)).equals(object);
        Multimap<Boolean, DoubleObjectPair<Integer>> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0, Integer.valueOf(2))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0, Integer.valueOf(4))));
    }

    @Test
    public void groupByEach() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Function<DoubleObjectPair<Integer>, MutableList<Boolean>> function = (DoubleObjectPair<Integer> object) -> Lists.mutable.of(PrimitiveTuples.pair(1.0, Integer.valueOf(2)).equals(object));
        Multimap<Boolean, DoubleObjectPair<Integer>> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1.0, Integer.valueOf(2))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2.0, Integer.valueOf(3))));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3.0, Integer.valueOf(4))));
    }

    @Test
    public void zip() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3);
        RichIterable<Pair<DoubleObjectPair<Integer>, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), 1), Tuples.pair(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), 1), Tuples.pair(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3);
        RichIterable<Pair<DoubleObjectPair<Integer>, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), 0), Tuples.pair(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2.0, Integer.valueOf(3)), 0), Tuples.pair(PrimitiveTuples.pair(1.0, Integer.valueOf(2)), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1.0, Integer.valueOf(2))), FastList.newListWith(PrimitiveTuples.pair(2.0, Integer.valueOf(3))), FastList.newListWith(PrimitiveTuples.pair(3.0, Integer.valueOf(4)))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
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
        RichIterable<DoubleObjectPair<Integer>> notEmpty = this.newWith(1.0, 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, DoubleObjectPair<Integer>> sumAggregator = (AtomicInteger aggregate, DoubleObjectPair<Integer> value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 2, 2.0, 3, 3.0, 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3.0:4").intValue());
        Assert.assertEquals(2, aggregation.get("2.0:3").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, DoubleObjectPair<Integer>, Integer> sumAggregator = (Integer aggregate, DoubleObjectPair<Integer> value) -> (int) (aggregate + value.getOne());
        RichIterable<DoubleObjectPair<Integer>> collection = this.newWith(1.0, 1, 1.0, 2, 2.0, 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2.0:3").intValue());
        Assert.assertEquals(1, aggregation.get("1.0:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractDoubleObjectMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractDoubleObjectMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> toBiMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractDoubleObjectMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractDoubleObjectMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractDoubleObjectMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractDoubleObjectMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractDoubleObjectMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractDoubleObjectMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractDoubleObjectMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractDoubleObjectMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractDoubleObjectMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractDoubleObjectMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractDoubleObjectMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractDoubleObjectMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractDoubleObjectMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractDoubleObjectMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractDoubleObjectMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractDoubleObjectMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractDoubleObjectMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractDoubleObjectMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractDoubleObjectMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractDoubleObjectMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractDoubleObjectMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractDoubleObjectMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractDoubleObjectMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractDoubleObjectMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleObjectMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleObjectMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractDoubleObjectMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractDoubleObjectMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractDoubleObjectMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractDoubleObjectMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractDoubleObjectMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractDoubleObjectMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractDoubleObjectMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractDoubleObjectMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractDoubleObjectMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractDoubleObjectMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractDoubleObjectMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractDoubleObjectMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractDoubleObjectMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractDoubleObjectMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractDoubleObjectMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractDoubleObjectMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractDoubleObjectMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractDoubleObjectMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractDoubleObjectMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractDoubleObjectMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractDoubleObjectMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractDoubleObjectMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractDoubleObjectMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractDoubleObjectMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractDoubleObjectMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleObjectMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleObjectMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractDoubleObjectMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractDoubleObjectMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractDoubleObjectMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractDoubleObjectMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractDoubleObjectMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractDoubleObjectMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractDoubleObjectMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractDoubleObjectMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractDoubleObjectMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractDoubleObjectMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractDoubleObjectMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractDoubleObjectMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractDoubleObjectMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractDoubleObjectMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractDoubleObjectMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractDoubleObjectMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.toBiMap = AbstractDoubleObjectMapKeyValuesViewTestCase::toBiMap;
            this.payloads.testToString = AbstractDoubleObjectMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractDoubleObjectMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractDoubleObjectMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractDoubleObjectMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractDoubleObjectMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractDoubleObjectMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractDoubleObjectMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractDoubleObjectMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractDoubleObjectMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractDoubleObjectMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractDoubleObjectMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractDoubleObjectMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractDoubleObjectMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractDoubleObjectMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractDoubleObjectMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractDoubleObjectMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractDoubleObjectMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractDoubleObjectMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
