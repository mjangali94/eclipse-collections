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
import org.eclipse.collections.api.map.primitive.IntByteMap;
import org.eclipse.collections.api.map.sorted.MutableSortedMap;
import org.eclipse.collections.api.multimap.Multimap;
import org.eclipse.collections.api.partition.PartitionIterable;
import org.eclipse.collections.api.set.MutableSet;
import org.eclipse.collections.api.set.sorted.MutableSortedSet;
import org.eclipse.collections.api.tuple.Pair;
import org.eclipse.collections.api.tuple.primitive.IntBytePair;
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
 * Abstract JUnit test for {@link IntByteMap#keyValuesView()}.
 * This file was automatically generated from template file abstractPrimitivePrimitiveMapKeyValuesViewTestCase.stg.
 */
public abstract class AbstractIntByteMapKeyValuesViewTestCase {

    public abstract IntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2, int key3, byte value3);

    public abstract IntByteMap newWithKeysValues(int key1, byte value1, int key2, byte value2);

    public abstract IntByteMap newWithKeysValues(int key1, byte value1);

    public abstract IntByteMap newEmpty();

    public RichIterable<IntBytePair> newWith() {
        return this.newEmpty().keyValuesView();
    }

    public RichIterable<IntBytePair> newWith(int key1, byte value1) {
        return this.newWithKeysValues(key1, value1).keyValuesView();
    }

    public RichIterable<IntBytePair> newWith(int key1, byte value1, int key2, byte value2) {
        return this.newWithKeysValues(key1, value1, key2, value2).keyValuesView();
    }

    public RichIterable<IntBytePair> newWith(int key1, byte value1, int key2, byte value2, int key3, byte value3) {
        return this.newWithKeysValues(key1, value1, key2, value2, key3, value3).keyValuesView();
    }

    @Test
    public void containsAllIterable() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Assert.assertTrue(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3))));
        Assert.assertFalse(collection.containsAllIterable(FastList.newListWith(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(1, (byte) 5))));
    }

    @Test
    public void containsAllArray() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Assert.assertTrue(collection.containsAllArguments(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3)));
        Assert.assertFalse(collection.containsAllArguments(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(1, (byte) 5)));
    }

    @Test
    public void forEach() {
        MutableList<IntBytePair> result = Lists.mutable.of();
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        collection.forEach(CollectionAddProcedure.on(result));
        Verify.assertSize(3, result);
        Verify.assertContainsAll(result, PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4));
        MutableList<IntBytePair> result2 = Lists.mutable.of();
        RichIterable<IntBytePair> collection2 = this.newWith(0, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        collection2.forEach(CollectionAddProcedure.on(result2));
        Verify.assertSize(3, result2);
        Verify.assertContainsAll(result2, PrimitiveTuples.pair(0, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4));
    }

    @Test
    public void forEachWith() {
        MutableBag<IntBytePair> result = Bags.mutable.of();
        MutableBag<Integer> result2 = Bags.mutable.of();
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 0, 2, (byte) 3, 3, (byte) 4);
        collection.forEachWith((IntBytePair argument1, Integer argument2) -> {
            result.add(argument1);
            result2.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, (byte) 0), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), result);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result2);
        MutableBag<IntBytePair> result3 = Bags.mutable.of();
        MutableBag<Integer> result4 = Bags.mutable.of();
        RichIterable<IntBytePair> collection2 = this.newWith(2, (byte) 5, 6, (byte) 3, 3, (byte) 4);
        collection2.forEachWith((IntBytePair argument1, Integer argument2) -> {
            result3.add(argument1);
            result4.add(argument2);
        }, 0);
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(2, (byte) 5), PrimitiveTuples.pair(6, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), result3);
        Assert.assertEquals(Bags.immutable.of(0, 0, 0), result4);
    }

    @Test
    public void forEachWithIndex() {
        MutableBag<IntBytePair> elements = Bags.mutable.of();
        MutableBag<Integer> indexes = Bags.mutable.of();
        RichIterable<IntBytePair> collection = this.newWith(2, (byte) 2, 6, (byte) 3, 3, (byte) 4);
        collection.forEachWithIndex((IntBytePair object, int index) -> {
            elements.add(object);
            indexes.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(2, (byte) 2), PrimitiveTuples.pair(6, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), elements);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes);
        MutableBag<IntBytePair> elements2 = Bags.mutable.of();
        MutableBag<Integer> indexes2 = Bags.mutable.of();
        RichIterable<IntBytePair> collection2 = this.newWith(0, (byte) 1, 2, (byte) 3, 3, (byte) 4);
        collection2.forEachWithIndex((IntBytePair object, int index) -> {
            elements2.add(object);
            indexes2.add(index);
        });
        Assert.assertEquals(Bags.mutable.of(PrimitiveTuples.pair(0, (byte) 1), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), elements2);
        Assert.assertEquals(Bags.mutable.of(0, 1, 2), indexes2);
    }

    @Test
    public void select() {
        MutableList<IntBytePair> result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).select(PrimitiveTuples.pair(2, (byte) 3)::equals).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, (byte) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, (byte) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, (byte) 4), result);
    }

    @Test
    public void selectWith() {
        MutableList<IntBytePair> result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).selectWith(Object::equals, PrimitiveTuples.pair(2, (byte) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, (byte) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, (byte) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, (byte) 4), result);
    }

    @Test
    public void selectWith_target() {
        HashBag<IntBytePair> result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).selectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2, (byte) 3), HashBag.<IntBytePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(3, (byte) 4)), result);
    }

    @Test
    public void reject() {
        MutableList<IntBytePair> result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).reject(Predicates.notEqual(PrimitiveTuples.pair(2, (byte) 3))).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, (byte) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, (byte) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, (byte) 4), result);
    }

    @Test
    public void rejectWith() {
        MutableList<IntBytePair> result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).rejectWith(Predicates2.notEqual(), PrimitiveTuples.pair(2, (byte) 3)).toList();
        Verify.assertContains(PrimitiveTuples.pair(2, (byte) 3), result);
        Verify.assertNotContains(PrimitiveTuples.pair(1, (byte) 2), result);
        Verify.assertNotContains(PrimitiveTuples.pair(3, (byte) 4), result);
    }

    @Test
    public void rejectWith_target() {
        HashBag<IntBytePair> result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).rejectWith(Object::equals, PrimitiveTuples.pair(2, (byte) 3), HashBag.<IntBytePair>newBag());
        Assert.assertEquals(Bags.immutable.of(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(3, (byte) 4)), result);
    }

    @Test
    public void selectInstancesOf() {
        RichIterable<IntBytePair> pairs = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Verify.assertIterableEmpty(pairs.selectInstancesOf(Integer.class));
        Verify.assertContainsAll(pairs.selectInstancesOf(IntBytePair.class), PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(3, (byte) 4), PrimitiveTuples.pair(2, (byte) 3));
    }

    @Test
    public void collect() {
        RichIterable<Integer> result1 = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collect((IntBytePair object) -> (int) object.getOne());
        Assert.assertEquals(Bags.immutable.of(1, 2, 3), result1.toBag());
        RichIterable<Long> result2 = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collect((IntBytePair object) -> (long) object.getTwo());
        Assert.assertEquals(Bags.immutable.of(2L, 3L, 4L), result2.toBag());
    }

    @Test
    public void collectBoolean() {
        BooleanIterable result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectBoolean((IntBytePair each) -> (each.getOne() % 2) == 0);
        Assert.assertEquals(BooleanHashBag.newBagWith(true, false, false), result.toBag());
    }

    @Test
    public void collectByte() {
        ByteIterable result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectByte((IntBytePair anObject) -> (byte) anObject.getOne());
        Assert.assertEquals(ByteHashBag.newBagWith((byte) 1, (byte) 2, (byte) 3), result.toBag());
    }

    @Test
    public void collectChar() {
        CharIterable result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectChar((IntBytePair anObject) -> (char) anObject.getOne());
        Assert.assertEquals(CharHashBag.newBagWith((char) 1, (char) 2, (char) 3), result.toBag());
    }

    @Test
    public void collectDouble() {
        DoubleIterable result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectDouble((IntBytePair anObject) -> (double) anObject.getOne());
        Assert.assertEquals(DoubleHashBag.newBagWith(1.0, 2.0, 3.0), result.toBag());
    }

    @Test
    public void collectFloat() {
        FloatIterable result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectFloat((IntBytePair anObject) -> (float) anObject.getOne());
        Assert.assertEquals(FloatHashBag.newBagWith(1.0f, 2.0f, 3.0f), result.toBag());
    }

    @Test
    public void collectInt() {
        IntIterable result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectInt((IntBytePair anObject) -> (int) anObject.getOne());
        Assert.assertEquals(IntHashBag.newBagWith(1, 2, 3), result.toBag());
    }

    @Test
    public void collectLong() {
        LongIterable result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectLong((IntBytePair anObject) -> (long) anObject.getOne());
        Assert.assertEquals(LongHashBag.newBagWith(1L, 2L, 3L), result.toBag());
    }

    @Test
    public void collectShort() {
        ShortIterable result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectShort((IntBytePair anObject) -> (short) anObject.getOne());
        Assert.assertEquals(ShortHashBag.newBagWith((short) 1, (short) 2, (short) 3), result.toBag());
    }

    @Test
    public void flatCollect() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Function<IntBytePair, MutableList<String>> function = (IntBytePair object) -> FastList.newListWith(String.valueOf(object));
        Verify.assertListsEqual(FastList.newListWith("1:2", "2:3", "3:4"), collection.flatCollect(function).toSortedList());
        Verify.assertSetsEqual(UnifiedSet.newSetWith("1:2", "2:3", "3:4"), collection.flatCollect(function, UnifiedSet.<String>newSet()));
    }

    @Test
    public void detect() {
        Assert.assertEquals(PrimitiveTuples.pair(2, (byte) 3), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).detect(PrimitiveTuples.pair(2, (byte) 3)::equals));
        Assert.assertNull(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).detect(PrimitiveTuples.pair(2, (byte) 4)::equals));
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
        Assert.assertEquals(PrimitiveTuples.pair(1, (byte) 2), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max() {
        Assert.assertEquals(PrimitiveTuples.pair(3, (byte) 4), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void min_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(1, (byte) 2), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).min(Comparators.naturalOrder()));
    }

    @Test
    public void max_without_comparator() {
        Assert.assertEquals(PrimitiveTuples.pair(3, (byte) 4), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).max(Comparators.naturalOrder()));
    }

    @Test
    public void minBy() {
        Assert.assertEquals(PrimitiveTuples.pair(2, (byte) 3), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).minBy((IntBytePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void maxBy() {
        Assert.assertEquals(PrimitiveTuples.pair(1, (byte) 2), this.newWith(1, (byte) 2, 2, (byte) 3, 4, (byte) 5).maxBy((IntBytePair object) -> (int) object.getOne() & 1));
    }

    @Test
    public void detectWith() {
        Assert.assertEquals(PrimitiveTuples.pair(2, (byte) 3), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).detectWith(Object::equals, PrimitiveTuples.pair(2, (byte) 3)));
        Assert.assertNull(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).detectWith(Object::equals, PrimitiveTuples.pair(2, 4L)));
    }

    @Test
    public void detectIfNone() {
        Function0<IntBytePair> function = Functions0.value(PrimitiveTuples.pair(5, (byte) 6));
        Assert.assertEquals(PrimitiveTuples.pair(2, (byte) 3), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).detectIfNone(PrimitiveTuples.pair(2, (byte) 3)::equals, function));
        Assert.assertEquals(PrimitiveTuples.pair(5, (byte) 6), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).detectIfNone(PrimitiveTuples.pair(2, 4L)::equals, function));
    }

    @Test
    public void detectWithIfNoneBlock() {
        Function0<IntBytePair> function = Functions0.value(PrimitiveTuples.pair(5, (byte) 6));
        Assert.assertEquals(PrimitiveTuples.pair(2, (byte) 3), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, (byte) 3), function));
        Assert.assertEquals(PrimitiveTuples.pair(5, (byte) 6), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).detectWithIfNone(Object::equals, PrimitiveTuples.pair(2, 4L), function));
    }

    @Test
    public void allSatisfy() {
        Assert.assertTrue(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).allSatisfy(IntBytePair.class::isInstance));
        Assert.assertFalse(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).allSatisfy(PrimitiveTuples.pair(2, (byte) 3)::equals));
    }

    @Test
    public void allSatisfyWith() {
        Assert.assertTrue(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).allSatisfyWith(Predicates2.instanceOf(), IntBytePair.class));
        Assert.assertFalse(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).allSatisfyWith(Object::equals, PrimitiveTuples.pair(2, (byte) 3)));
    }

    @Test
    public void noneSatisfy() {
        Assert.assertTrue(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).noneSatisfy(Boolean.class::isInstance));
        Assert.assertFalse(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).noneSatisfy(PrimitiveTuples.pair(2, (byte) 3)::equals));
    }

    @Test
    public void noneSatisfyWith() {
        Assert.assertTrue(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).noneSatisfyWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertFalse(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).noneSatisfyWith(Object::equals, PrimitiveTuples.pair(2, (byte) 3)));
    }

    @Test
    public void anySatisfy() {
        Assert.assertTrue(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).anySatisfy(PrimitiveTuples.pair(2, (byte) 3)::equals));
        Assert.assertFalse(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).anySatisfy(PrimitiveTuples.pair(2, (byte) 5)::equals));
    }

    @Test
    public void anySatisfyWith() {
        Assert.assertTrue(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, (byte) 3)));
        Assert.assertFalse(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).anySatisfyWith(Object::equals, PrimitiveTuples.pair(2, (byte) 5)));
    }

    @Test
    public void count() {
        Assert.assertEquals(0, this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).count(Boolean.class::isInstance));
        Assert.assertEquals(3, this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).count(IntBytePair.class::isInstance));
        Assert.assertEquals(1, this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).count(PrimitiveTuples.pair(2, (byte) 3)::equals));
    }

    @Test
    public void countWith() {
        Assert.assertEquals(0, this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).countWith(Predicates2.instanceOf(), Boolean.class));
        Assert.assertEquals(3, this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).countWith(Predicates2.instanceOf(), IntBytePair.class));
        Assert.assertEquals(1, this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).countWith(Object::equals, PrimitiveTuples.pair(2, (byte) 3)));
    }

    @Test
    public void collectIf() {
        Verify.assertContainsAll(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectIf(IntBytePair.class::isInstance, String::valueOf), "1:2", "2:3", "3:4");
        Verify.assertContainsAll(this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectIf(IntBytePair.class::isInstance, String::valueOf, UnifiedSet.<String>newSet()), "1:2", "2:3", "3:4");
    }

    @Test
    public void collectWith() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectWith((IntBytePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L).toBag());
    }

    @Test
    public void collectWith_target() {
        Assert.assertEquals(Bags.mutable.of(4L, 6L, 8L), this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).collectWith((IntBytePair argument1, Long argument2) -> (long) (argument1.getOne() + argument1.getTwo() + argument2), 1L, HashBag.<Long>newBag()));
    }

    @Test
    public void getFirst() {
        IntBytePair first = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).getFirst();
        Assert.assertTrue(PrimitiveTuples.pair(1, (byte) 2).equals(first) || PrimitiveTuples.pair(2, (byte) 3).equals(first) || PrimitiveTuples.pair(3, (byte) 4).equals(first));
        Assert.assertEquals(PrimitiveTuples.pair(1, (byte) 2), this.newWith(1, (byte) 2).getFirst());
    }

    @Test
    public void getLast() {
        IntBytePair last = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).getLast();
        Assert.assertTrue(PrimitiveTuples.pair(1, (byte) 2).equals(last) || PrimitiveTuples.pair(2, (byte) 3).equals(last) || PrimitiveTuples.pair(3, (byte) 4).equals(last));
        Assert.assertEquals(PrimitiveTuples.pair(1, (byte) 2), this.newWith(1, (byte) 2).getLast());
    }

    @Test
    public void isEmpty() {
        Verify.assertIterableEmpty(this.newWith());
        Verify.assertIterableNotEmpty(this.newWith(1, (byte) 2));
        Assert.assertTrue(this.newWith(1, (byte) 2).notEmpty());
    }

    @Test
    public void iterator() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 0, (byte) 3, 3, (byte) 4);
        MutableBag<IntBytePair> actual = Bags.mutable.of();
        Iterator<IntBytePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test
    public void iterator_no_sentinels() {
        RichIterable<IntBytePair> objects = this.newWith(2, (byte) 3, 4, (byte) 3, 3, (byte) 4);
        MutableBag<IntBytePair> actual = Bags.mutable.of();
        Iterator<IntBytePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            actual.add(iterator.next());
        }
        Assert.assertFalse(iterator.hasNext());
        Assert.assertEquals(objects.toBag(), actual);
    }

    @Test(expected = NoSuchElementException.class)
    public void iterator_next_throws() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Iterator<IntBytePair> iterator = objects.iterator();
        for (int i = objects.size(); i-- > 0; ) {
            Assert.assertTrue(iterator.hasNext());
            iterator.next();
        }
        Assert.assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = UnsupportedOperationException.class)
    public void iterator_remove_throws() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Iterator<IntBytePair> iterator = objects.iterator();
        iterator.remove();
    }

    @Test
    public void injectInto() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Long result = objects.injectInto(1L, (Long argument1, IntBytePair argument2) -> (long) (argument1 + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(Long.valueOf(16), result);
    }

    @Test
    public void injectIntoInt() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        int result = objects.injectInto(1, (int intParameter, IntBytePair argument2) -> (int) (intParameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoLong() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        long result = objects.injectInto(1L, (long parameter, IntBytePair argument2) -> (long) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16, result);
    }

    @Test
    public void injectIntoDouble() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        double result = objects.injectInto(1.0, (double parameter, IntBytePair argument2) -> (double) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void injectIntoFloat() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        float result = objects.injectInto(1.0f, (float parameter, IntBytePair argument2) -> (float) (parameter + argument2.getOne() + argument2.getTwo()));
        Assert.assertEquals(16.0, result, 0.0);
    }

    @Test
    public void sumFloat() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        double actual = objects.sumOfFloat((IntBytePair each) -> (float) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumDouble() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        double actual = objects.sumOfDouble((IntBytePair each) -> (double) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15.0, actual, 0.0);
    }

    @Test
    public void sumInteger() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        long actual = objects.sumOfInt((IntBytePair each) -> (int) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void sumLong() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        long actual = objects.sumOfLong((IntBytePair each) -> (long) (each.getOne() + each.getTwo()));
        Assert.assertEquals(15, actual);
    }

    @Test
    public void toArray() {
        RichIterable<IntBytePair> objects = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Object[] array = objects.toArray();
        Verify.assertSize(3, array);
        IntBytePair[] array2 = objects.toArray(new IntBytePair[3]);
        Verify.assertSize(3, array2);
    }

    @Test
    public void partition() {
        PartitionIterable<IntBytePair> result = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).partition(PrimitiveTuples.pair(2, (byte) 3)::equals);
        Verify.assertContains(PrimitiveTuples.pair(2, (byte) 3), result.getSelected().toList());
        Verify.assertIterableSize(1, result.getSelected());
        Verify.assertContains(PrimitiveTuples.pair(1, (byte) 2), result.getRejected().toList());
        Verify.assertContains(PrimitiveTuples.pair(3, (byte) 4), result.getRejected().toList());
        Verify.assertIterableSize(2, result.getRejected());
    }

    @Test
    public void toList() {
        MutableList<IntBytePair> list = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).toList();
        Verify.assertContainsAll(list, PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4));
    }

    @Test
    public void toBag() {
        MutableBag<IntBytePair> bag = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4).toBag();
        Verify.assertContainsAll(bag, PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4));
    }

    @Test
    public void toSortedList_natural_ordering() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableList<IntBytePair> list = pairs.toSortedList();
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), list);
    }

    @Test
    public void toSortedList_with_comparator() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableList<IntBytePair> list = pairs.toSortedList(Comparators.reverseNaturalOrder());
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(3, (byte) 4), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(1, (byte) 2)), list);
    }

    @Test
    public void toSortedListBy() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableList<IntBytePair> list = pairs.toSortedListBy(String::valueOf);
        Assert.assertEquals(Lists.mutable.of(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), list);
    }

    @Test
    public void toSortedBag_natural_ordering() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableSortedBag<IntBytePair> bag = pairs.toSortedBag();
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), bag);
    }

    @Test
    public void toSortedBag_with_comparator() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableSortedBag<IntBytePair> bag = pairs.toSortedBag(Comparators.reverseNaturalOrder());
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3, (byte) 4), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(1, (byte) 2)), bag);
    }

    @Test
    public void toSortedBagBy() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableSortedBag<IntBytePair> bag = pairs.toSortedBagBy(String::valueOf);
        Verify.assertSortedBagsEqual(TreeBag.newBagWith(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), bag);
    }

    @Test
    public void toSortedSet_natural_ordering() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableSortedSet<IntBytePair> set = pairs.toSortedSet();
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), set);
    }

    @Test
    public void toSortedSet_with_comparator() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableSortedSet<IntBytePair> set = pairs.toSortedSet(Comparators.reverseNaturalOrder());
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(Comparators.reverseNaturalOrder(), PrimitiveTuples.pair(3, (byte) 4), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(1, (byte) 2)), set);
    }

    @Test
    public void toSortedSetBy() {
        RichIterable<IntBytePair> pairs = this.newWith(2, (byte) 3, 1, (byte) 2, 3, (byte) 4);
        MutableSortedSet<IntBytePair> set = pairs.toSortedSetBy(String::valueOf);
        Verify.assertSortedSetsEqual(TreeSortedSet.newSetWith(PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4)), set);
    }

    @Test
    public void toSet() {
        RichIterable<IntBytePair> pairs = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        MutableSet<IntBytePair> set = pairs.toSet();
        Verify.assertContainsAll(set, PrimitiveTuples.pair(1, (byte) 2), PrimitiveTuples.pair(2, (byte) 3), PrimitiveTuples.pair(3, (byte) 4));
    }

    @Test
    public void toMap() {
        RichIterable<IntBytePair> pairs = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        MutableMap<String, String> map = pairs.toMap(String::valueOf, String::valueOf);
        Assert.assertEquals(UnifiedMap.newWithKeysValues("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap() {
        RichIterable<IntBytePair> pairs = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith("1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMap_with_comparator() {
        RichIterable<IntBytePair> pairs = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMap(Comparators.reverseNaturalOrder(), String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.reverseNaturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void toSortedMapBy() {
        RichIterable<IntBytePair> pairs = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        MutableSortedMap<String, String> map = pairs.toSortedMapBy(String::valueOf, String::valueOf, String::valueOf);
        Assert.assertEquals(TreeSortedMap.newMapWith(Comparators.naturalOrder(), "1:2", "1:2", "2:3", "2:3", "3:4", "3:4"), map);
    }

    @Test
    public void testToString() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3);
        Assert.assertTrue("[1:2, 2:3]".equals(collection.toString()) || "[2:3, 1:2]".equals(collection.toString()));
    }

    @Test
    public void makeString() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString() + ']');
    }

    @Test
    public void makeStringWithSeparator() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Assert.assertEquals(collection.toString(), '[' + collection.makeString(", ") + ']');
    }

    @Test
    public void makeStringWithSeparatorAndStartAndEnd() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Assert.assertEquals(collection.toString(), collection.makeString("[", ", ", "]"));
    }

    @Test
    public void appendString() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder);
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparator() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, ", ");
        Assert.assertEquals(collection.toString(), '[' + builder.toString() + ']');
    }

    @Test
    public void appendStringWithSeparatorAndStartAndEnd() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Appendable builder = new StringBuilder();
        collection.appendString(builder, "[", ", ", "]");
        Assert.assertEquals(collection.toString(), builder.toString());
    }

    @Test
    public void groupBy() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Function<IntBytePair, Boolean> function = (IntBytePair object) -> PrimitiveTuples.pair(1, (byte) 2).equals(object);
        Multimap<Boolean, IntBytePair> multimap = collection.groupBy(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1, (byte) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2, (byte) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3, (byte) 4)));
    }

    @Test
    public void groupByEach() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Function<IntBytePair, MutableList<Boolean>> function = (IntBytePair object) -> Lists.mutable.of(PrimitiveTuples.pair(1, (byte) 2).equals(object));
        Multimap<Boolean, IntBytePair> multimap = collection.groupByEach(function);
        Assert.assertEquals(3, multimap.size());
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.TRUE, PrimitiveTuples.pair(1, (byte) 2)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(2, (byte) 3)));
        Assert.assertTrue(multimap.containsKeyAndValue(Boolean.FALSE, PrimitiveTuples.pair(3, (byte) 4)));
    }

    @Test
    public void zip() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3);
        RichIterable<Pair<IntBytePair, Integer>> result = collection.zip(Interval.oneTo(5));
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1, (byte) 2), 1), Tuples.pair(PrimitiveTuples.pair(2, (byte) 3), 2)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2, (byte) 3), 1), Tuples.pair(PrimitiveTuples.pair(1, (byte) 2), 2)).equals(result.toBag()));
    }

    @Test
    public void zipWithIndex() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3);
        RichIterable<Pair<IntBytePair, Integer>> result = collection.zipWithIndex();
        Assert.assertTrue(Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(1, (byte) 2), 0), Tuples.pair(PrimitiveTuples.pair(2, (byte) 3), 1)).equals(result.toBag()) || Bags.mutable.of(Tuples.pair(PrimitiveTuples.pair(2, (byte) 3), 0), Tuples.pair(PrimitiveTuples.pair(1, (byte) 2), 1)).equals(result.toBag()));
    }

    @Test
    public void chunk() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        Assert.assertEquals(Bags.immutable.of(FastList.newListWith(PrimitiveTuples.pair(1, (byte) 2)), FastList.newListWith(PrimitiveTuples.pair(2, (byte) 3)), FastList.newListWith(PrimitiveTuples.pair(3, (byte) 4))), collection.chunk(1).toBag());
    }

    @Test(expected = IllegalArgumentException.class)
    public void chunk_zero_throws() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        collection.chunk(0);
    }

    @Test
    public void chunk_large_size() {
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
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
        RichIterable<IntBytePair> notEmpty = this.newWith(1, (byte) 2);
        Verify.assertIterableNotEmpty(notEmpty);
    }

    @Test
    public void aggregateByMutating() {
        Function0<AtomicInteger> valueCreator = Functions0.zeroAtomicInteger();
        Procedure2<AtomicInteger, IntBytePair> sumAggregator = (AtomicInteger aggregate, IntBytePair value) -> aggregate.addAndGet((int) value.getOne());
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 2, 2, (byte) 3, 3, (byte) 4);
        MapIterable<String, AtomicInteger> aggregation = collection.aggregateInPlaceBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(3, aggregation.get("3:4").intValue());
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @Test
    public void aggregateByNonMutating() {
        Function0<Integer> valueCreator = Functions0.value(0);
        Function2<Integer, IntBytePair, Integer> sumAggregator = (Integer aggregate, IntBytePair value) -> (int) (aggregate + value.getOne());
        RichIterable<IntBytePair> collection = this.newWith(1, (byte) 1, 1, (byte) 2, 2, (byte) 3);
        MapIterable<String, Integer> aggregation = collection.aggregateBy(String::valueOf, valueCreator, sumAggregator);
        Assert.assertEquals(2, aggregation.get("2:3").intValue());
        Assert.assertEquals(1, aggregation.get("1:2").intValue());
    }

    @org.openjdk.jmh.annotations.State(org.openjdk.jmh.annotations.Scope.Thread)
    public static class _Benchmark {

        private _Payloads payloads;

        private AbstractIntByteMapKeyValuesViewTestCase instance;

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

        private void runBenchmark(se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> payload) throws java.lang.Throwable {
            this.instance = new AbstractIntByteMapKeyValuesViewTestCase();
            payload.accept(this.instance);
        }

        private static class _Payloads {

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> containsAllIterable;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> containsAllArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> forEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> forEachWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> forEachWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> select;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> selectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> selectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> reject;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> rejectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> rejectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> selectInstancesOf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectBoolean;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectByte;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectChar;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectShort;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> flatCollect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> detect;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> min_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> max_empty_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> min;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> max;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> min_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> max_without_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> minBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> maxBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> detectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> detectIfNone;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> detectWithIfNoneBlock;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> allSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> allSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> noneSatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> noneSatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> anySatisfy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> anySatisfyWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> count;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> countWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectIf;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectWith;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> collectWith_target;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> getFirst;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> getLast;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> isEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> iterator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> iterator_no_sentinels;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> iterator_next_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> iterator_remove_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> injectInto;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> injectIntoInt;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> injectIntoLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> injectIntoDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> injectIntoFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> sumFloat;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> sumDouble;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> sumInteger;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> sumLong;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toArray;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> partition;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toList;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toBag;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedList_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedList_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedListBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedBag_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedBag_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedBagBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedSet_natural_ordering;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedSet_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedSetBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSet;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedMap;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedMap_with_comparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> toSortedMapBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> testToString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> makeString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> makeStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> makeStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> appendString;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> appendStringWithSeparator;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> appendStringWithSeparatorAndStartAndEnd;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> groupBy;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> groupByEach;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> zip;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> zipWithIndex;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> chunk;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> chunk_zero_throws;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> chunk_large_size;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> empty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> notEmpty;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> aggregateByMutating;

            public se.chalmers.ju2jmh.api.ThrowingConsumer<AbstractIntByteMapKeyValuesViewTestCase> aggregateByNonMutating;
        }

        @org.openjdk.jmh.annotations.Setup(org.openjdk.jmh.annotations.Level.Trial)
        public void makePayloads() {
            this.payloads = new _Payloads();
            this.payloads.containsAllIterable = AbstractIntByteMapKeyValuesViewTestCase::containsAllIterable;
            this.payloads.containsAllArray = AbstractIntByteMapKeyValuesViewTestCase::containsAllArray;
            this.payloads.forEach = AbstractIntByteMapKeyValuesViewTestCase::forEach;
            this.payloads.forEachWith = AbstractIntByteMapKeyValuesViewTestCase::forEachWith;
            this.payloads.forEachWithIndex = AbstractIntByteMapKeyValuesViewTestCase::forEachWithIndex;
            this.payloads.select = AbstractIntByteMapKeyValuesViewTestCase::select;
            this.payloads.selectWith = AbstractIntByteMapKeyValuesViewTestCase::selectWith;
            this.payloads.selectWith_target = AbstractIntByteMapKeyValuesViewTestCase::selectWith_target;
            this.payloads.reject = AbstractIntByteMapKeyValuesViewTestCase::reject;
            this.payloads.rejectWith = AbstractIntByteMapKeyValuesViewTestCase::rejectWith;
            this.payloads.rejectWith_target = AbstractIntByteMapKeyValuesViewTestCase::rejectWith_target;
            this.payloads.selectInstancesOf = AbstractIntByteMapKeyValuesViewTestCase::selectInstancesOf;
            this.payloads.collect = AbstractIntByteMapKeyValuesViewTestCase::collect;
            this.payloads.collectBoolean = AbstractIntByteMapKeyValuesViewTestCase::collectBoolean;
            this.payloads.collectByte = AbstractIntByteMapKeyValuesViewTestCase::collectByte;
            this.payloads.collectChar = AbstractIntByteMapKeyValuesViewTestCase::collectChar;
            this.payloads.collectDouble = AbstractIntByteMapKeyValuesViewTestCase::collectDouble;
            this.payloads.collectFloat = AbstractIntByteMapKeyValuesViewTestCase::collectFloat;
            this.payloads.collectInt = AbstractIntByteMapKeyValuesViewTestCase::collectInt;
            this.payloads.collectLong = AbstractIntByteMapKeyValuesViewTestCase::collectLong;
            this.payloads.collectShort = AbstractIntByteMapKeyValuesViewTestCase::collectShort;
            this.payloads.flatCollect = AbstractIntByteMapKeyValuesViewTestCase::flatCollect;
            this.payloads.detect = AbstractIntByteMapKeyValuesViewTestCase::detect;
            this.payloads.min_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntByteMapKeyValuesViewTestCase::min_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.max_empty_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntByteMapKeyValuesViewTestCase::max_empty_throws, java.util.NoSuchElementException.class);
            this.payloads.min = AbstractIntByteMapKeyValuesViewTestCase::min;
            this.payloads.max = AbstractIntByteMapKeyValuesViewTestCase::max;
            this.payloads.min_without_comparator = AbstractIntByteMapKeyValuesViewTestCase::min_without_comparator;
            this.payloads.max_without_comparator = AbstractIntByteMapKeyValuesViewTestCase::max_without_comparator;
            this.payloads.minBy = AbstractIntByteMapKeyValuesViewTestCase::minBy;
            this.payloads.maxBy = AbstractIntByteMapKeyValuesViewTestCase::maxBy;
            this.payloads.detectWith = AbstractIntByteMapKeyValuesViewTestCase::detectWith;
            this.payloads.detectIfNone = AbstractIntByteMapKeyValuesViewTestCase::detectIfNone;
            this.payloads.detectWithIfNoneBlock = AbstractIntByteMapKeyValuesViewTestCase::detectWithIfNoneBlock;
            this.payloads.allSatisfy = AbstractIntByteMapKeyValuesViewTestCase::allSatisfy;
            this.payloads.allSatisfyWith = AbstractIntByteMapKeyValuesViewTestCase::allSatisfyWith;
            this.payloads.noneSatisfy = AbstractIntByteMapKeyValuesViewTestCase::noneSatisfy;
            this.payloads.noneSatisfyWith = AbstractIntByteMapKeyValuesViewTestCase::noneSatisfyWith;
            this.payloads.anySatisfy = AbstractIntByteMapKeyValuesViewTestCase::anySatisfy;
            this.payloads.anySatisfyWith = AbstractIntByteMapKeyValuesViewTestCase::anySatisfyWith;
            this.payloads.count = AbstractIntByteMapKeyValuesViewTestCase::count;
            this.payloads.countWith = AbstractIntByteMapKeyValuesViewTestCase::countWith;
            this.payloads.collectIf = AbstractIntByteMapKeyValuesViewTestCase::collectIf;
            this.payloads.collectWith = AbstractIntByteMapKeyValuesViewTestCase::collectWith;
            this.payloads.collectWith_target = AbstractIntByteMapKeyValuesViewTestCase::collectWith_target;
            this.payloads.getFirst = AbstractIntByteMapKeyValuesViewTestCase::getFirst;
            this.payloads.getLast = AbstractIntByteMapKeyValuesViewTestCase::getLast;
            this.payloads.isEmpty = AbstractIntByteMapKeyValuesViewTestCase::isEmpty;
            this.payloads.iterator = AbstractIntByteMapKeyValuesViewTestCase::iterator;
            this.payloads.iterator_no_sentinels = AbstractIntByteMapKeyValuesViewTestCase::iterator_no_sentinels;
            this.payloads.iterator_next_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntByteMapKeyValuesViewTestCase::iterator_next_throws, java.util.NoSuchElementException.class);
            this.payloads.iterator_remove_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntByteMapKeyValuesViewTestCase::iterator_remove_throws, java.lang.UnsupportedOperationException.class);
            this.payloads.injectInto = AbstractIntByteMapKeyValuesViewTestCase::injectInto;
            this.payloads.injectIntoInt = AbstractIntByteMapKeyValuesViewTestCase::injectIntoInt;
            this.payloads.injectIntoLong = AbstractIntByteMapKeyValuesViewTestCase::injectIntoLong;
            this.payloads.injectIntoDouble = AbstractIntByteMapKeyValuesViewTestCase::injectIntoDouble;
            this.payloads.injectIntoFloat = AbstractIntByteMapKeyValuesViewTestCase::injectIntoFloat;
            this.payloads.sumFloat = AbstractIntByteMapKeyValuesViewTestCase::sumFloat;
            this.payloads.sumDouble = AbstractIntByteMapKeyValuesViewTestCase::sumDouble;
            this.payloads.sumInteger = AbstractIntByteMapKeyValuesViewTestCase::sumInteger;
            this.payloads.sumLong = AbstractIntByteMapKeyValuesViewTestCase::sumLong;
            this.payloads.toArray = AbstractIntByteMapKeyValuesViewTestCase::toArray;
            this.payloads.partition = AbstractIntByteMapKeyValuesViewTestCase::partition;
            this.payloads.toList = AbstractIntByteMapKeyValuesViewTestCase::toList;
            this.payloads.toBag = AbstractIntByteMapKeyValuesViewTestCase::toBag;
            this.payloads.toSortedList_natural_ordering = AbstractIntByteMapKeyValuesViewTestCase::toSortedList_natural_ordering;
            this.payloads.toSortedList_with_comparator = AbstractIntByteMapKeyValuesViewTestCase::toSortedList_with_comparator;
            this.payloads.toSortedListBy = AbstractIntByteMapKeyValuesViewTestCase::toSortedListBy;
            this.payloads.toSortedBag_natural_ordering = AbstractIntByteMapKeyValuesViewTestCase::toSortedBag_natural_ordering;
            this.payloads.toSortedBag_with_comparator = AbstractIntByteMapKeyValuesViewTestCase::toSortedBag_with_comparator;
            this.payloads.toSortedBagBy = AbstractIntByteMapKeyValuesViewTestCase::toSortedBagBy;
            this.payloads.toSortedSet_natural_ordering = AbstractIntByteMapKeyValuesViewTestCase::toSortedSet_natural_ordering;
            this.payloads.toSortedSet_with_comparator = AbstractIntByteMapKeyValuesViewTestCase::toSortedSet_with_comparator;
            this.payloads.toSortedSetBy = AbstractIntByteMapKeyValuesViewTestCase::toSortedSetBy;
            this.payloads.toSet = AbstractIntByteMapKeyValuesViewTestCase::toSet;
            this.payloads.toMap = AbstractIntByteMapKeyValuesViewTestCase::toMap;
            this.payloads.toSortedMap = AbstractIntByteMapKeyValuesViewTestCase::toSortedMap;
            this.payloads.toSortedMap_with_comparator = AbstractIntByteMapKeyValuesViewTestCase::toSortedMap_with_comparator;
            this.payloads.toSortedMapBy = AbstractIntByteMapKeyValuesViewTestCase::toSortedMapBy;
            this.payloads.testToString = AbstractIntByteMapKeyValuesViewTestCase::testToString;
            this.payloads.makeString = AbstractIntByteMapKeyValuesViewTestCase::makeString;
            this.payloads.makeStringWithSeparator = AbstractIntByteMapKeyValuesViewTestCase::makeStringWithSeparator;
            this.payloads.makeStringWithSeparatorAndStartAndEnd = AbstractIntByteMapKeyValuesViewTestCase::makeStringWithSeparatorAndStartAndEnd;
            this.payloads.appendString = AbstractIntByteMapKeyValuesViewTestCase::appendString;
            this.payloads.appendStringWithSeparator = AbstractIntByteMapKeyValuesViewTestCase::appendStringWithSeparator;
            this.payloads.appendStringWithSeparatorAndStartAndEnd = AbstractIntByteMapKeyValuesViewTestCase::appendStringWithSeparatorAndStartAndEnd;
            this.payloads.groupBy = AbstractIntByteMapKeyValuesViewTestCase::groupBy;
            this.payloads.groupByEach = AbstractIntByteMapKeyValuesViewTestCase::groupByEach;
            this.payloads.zip = AbstractIntByteMapKeyValuesViewTestCase::zip;
            this.payloads.zipWithIndex = AbstractIntByteMapKeyValuesViewTestCase::zipWithIndex;
            this.payloads.chunk = AbstractIntByteMapKeyValuesViewTestCase::chunk;
            this.payloads.chunk_zero_throws = new se.chalmers.ju2jmh.api.ExceptionTest<>(AbstractIntByteMapKeyValuesViewTestCase::chunk_zero_throws, java.lang.IllegalArgumentException.class);
            this.payloads.chunk_large_size = AbstractIntByteMapKeyValuesViewTestCase::chunk_large_size;
            this.payloads.empty = AbstractIntByteMapKeyValuesViewTestCase::empty;
            this.payloads.notEmpty = AbstractIntByteMapKeyValuesViewTestCase::notEmpty;
            this.payloads.aggregateByMutating = AbstractIntByteMapKeyValuesViewTestCase::aggregateByMutating;
            this.payloads.aggregateByNonMutating = AbstractIntByteMapKeyValuesViewTestCase::aggregateByNonMutating;
        }
    }
}
